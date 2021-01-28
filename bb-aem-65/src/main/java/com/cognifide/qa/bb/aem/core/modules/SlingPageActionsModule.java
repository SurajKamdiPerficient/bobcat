/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2018 Wunderman Thompson Technology
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.cognifide.qa.bb.aem.core.modules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognifide.qa.bb.aem.core.api.AemActions;
import com.cognifide.qa.bb.aem.core.pages.sling.CreatePage;
import com.cognifide.qa.bb.aem.core.pages.sling.DeletePage;
import com.cognifide.qa.bb.api.actions.ActionWithData;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/**
 * Module that need to be installed to use page creation in AEM
 */
public class SlingPageActionsModule extends AbstractModule {
  private static final Logger LOG = LoggerFactory.getLogger(SlingPageActionsModule.class);

  @Override
  protected void configure() {
    LOG.debug("Configuring Bobcat module: {}", getClass().getSimpleName());

    MapBinder<String, ActionWithData> slingPageActions =
        MapBinder.newMapBinder(binder(), String.class, ActionWithData.class);
    slingPageActions.addBinding(AemActions.CREATE_PAGE_VIA_SLING).to(CreatePage.class);
    slingPageActions.addBinding(AemActions.DELETE_PAGE_VIA_SLING).to(DeletePage.class);
  }
}
