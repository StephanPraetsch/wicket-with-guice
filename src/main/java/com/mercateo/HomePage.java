package com.mercateo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import com.google.inject.Inject;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @Inject
    private SayHello say;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("version", new Model<String>(getApplication().getFrameworkSettings()
                .getVersion())));

        add(new Label("hello", new SayHelloModel(say, getPageParameters().get("s"))));

        add(new SayHelloForm("helloForm", new Model<String>()));

    }

}
