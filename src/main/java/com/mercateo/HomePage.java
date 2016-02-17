package com.mercateo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @Inject
    private Injector inj;

    public HomePage(PageParameters pp) {
        super(pp);
        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        add(new Label("hello", pp.get("s").toString(inj.getInstance(SayHello.class).hello(
                "john"))));
        add(inj.getInstance(SayHelloForm.class));
    }

}
