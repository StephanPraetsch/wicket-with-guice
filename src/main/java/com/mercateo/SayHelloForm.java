package com.mercateo;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SayHelloForm extends Form<Object> {

    private final TextField<String> inputField;

    @Inject
    private SayHello say;

    public SayHelloForm() {
        super("helloForm");
        this.inputField = new TextField<>("inputField", Model.of(""));
        add(inputField);
    }

    @Override
    public void onSubmit() {
        PageParameters pp = new PageParameters();
        pp.add("s", say.hello(inputField.getModelObject()));
        setResponsePage(HomePage.class, pp);
    }

}
