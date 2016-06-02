package com.mercateo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import com.google.inject.Inject;
import com.mercateo.foobar.FoobarDao;
import com.mercateo.foobar.FoobarSortableDataProvider;
import com.mercateo.foobar.FoobarTable;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    @Inject
    private FoobarDao dao;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("version", new Model<String>(getApplication().getFrameworkSettings()
                .getVersion())));

        add(createFoobarTable("foobarTable"));

    }

    private FoobarTable createFoobarTable(String id) {
        return new FoobarTable(id, new FoobarSortableDataProvider(dao));
    }

}
