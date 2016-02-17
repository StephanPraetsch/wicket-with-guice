package com.mercateo;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class HomePage0Test {

    private WicketTester tester;

    @Before
    public void setUp() {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(SayHello.class).toInstance(new SayHello() {
                    @Override
                    public String hello(String s) {
                        return "test " + s;
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
