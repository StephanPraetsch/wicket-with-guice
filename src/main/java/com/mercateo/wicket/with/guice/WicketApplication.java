package com.mercateo.wicket.with.guice;

import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class WicketApplication extends WebApplication {

    private final Injector injector;

    @Inject
    public WicketApplication(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void init() {
        super.init();
        getComponentInstantiationListeners().add(new GuiceComponentInjector(this, injector));
    }

}
