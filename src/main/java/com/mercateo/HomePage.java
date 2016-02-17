package com.mercateo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @Inject
    private Injector injector;

    public HomePage(PageParameters parameters) {
        super(parameters);

        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

        SayHello say = injector.getInstance(SayHello.class);
        add(new Label("hello", say.hello("john")));

    }

}
