package com.mercateo;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SayHelloForm extends Form<String> {

    public SayHelloForm(String id, IModel<String> sayHelloModel) {
        super(id, sayHelloModel);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new TextField<>("inputField", getModel()));
    }

    @Override
    public void onSubmit() {
        PageParameters pp = new PageParameters();
        pp.add("s", getModelObject());
        setResponsePage(HomePage.class, pp);
    }

}
