package com.mercateo;

import com.google.inject.AbstractModule;

public class MyAppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SayHello.class).to(SayHelloImpl.class);
    }

}
