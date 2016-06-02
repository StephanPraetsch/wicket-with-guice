package com.mercateo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mercateo.HomePage;
import com.mercateo.WicketApplication;
import com.mercateo.foobar.Foobar;
import com.mercateo.foobar.FoobarDao;

public class HomePage0Test {

    private WicketTester tester;

    @Before
    public void setUp() {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(FoobarDao.class).toInstance(new FoobarDao() {

                    Foobar f = new Foobar(LocalDateTime.now(), Integer.valueOf(1));

                    @Override
                    public Foobar get(Integer id) {
                        return f;
                    }

                    @Override
                    public Collection<Foobar> get() {
                        return Collections.singleton(f);
                    }
                });
            }
        });
        tester = new WicketTester(new WicketApplication(injector));
    }

    @Test
    public void homepageRendersSuccessfully() {
        // start and render the test page
        tester.startPage(HomePage.class);

        // assert rendered page class
        tester.assertRenderedPage(HomePage.class);
    }

}
