package com.mercateo.wicket.with.guice;

import com.google.inject.AbstractModule;
import com.mercateo.wicket.with.guice.foobar.FoobarDao;
import com.mercateo.wicket.with.guice.foobar.FoobarRepo;

public class MyAppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(FoobarDao.class).to(FoobarRepo.class);
    }

}
