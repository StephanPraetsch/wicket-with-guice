package com.mercateo;

import com.google.inject.AbstractModule;
import com.mercateo.foobar.FoobarDao;
import com.mercateo.foobar.FoobarRepo;

public class MyAppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(FoobarDao.class).to(FoobarRepo.class);
    }

}
