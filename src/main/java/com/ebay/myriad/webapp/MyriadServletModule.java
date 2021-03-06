package com.ebay.myriad.webapp;

import com.ebay.myriad.api.ClustersResource;
import com.ebay.myriad.api.ConfigurationResource;
import com.ebay.myriad.api.DashboardResource;
import com.ebay.myriad.api.SchedulerStateResource;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

public class MyriadServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(ClustersResource.class);
        bind(ConfigurationResource.class);
        bind(DashboardResource.class);
        bind(SchedulerStateResource.class);

        bind(GuiceContainer.class);
        bind(JacksonJaxbJsonProvider.class).in(Scopes.SINGLETON);
        serve("/*").with(GuiceContainer.class);
    }
}
