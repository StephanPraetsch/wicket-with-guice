package com.mercateo;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import com.google.inject.Inject;
import com.mercateo.wicket.with.guice.foobar.Foobar;
import com.mercateo.wicket.with.guice.foobar.FoobarRepo;
import com.mercateo.wicket.with.guice.foobar.FoobarSortableDataProvider;
import com.mercateo.wicket.with.guice.foobar.FoobarTable;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @Inject
    private SayHello say;

    @Inject
    private FoobarRepo repo;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("version", new Model<String>(getApplication().getFrameworkSettings()
                .getVersion())));

        add(new Label("hello", new SayHelloModel(say, getPageParameters().get("s"))));

        add(new SayHelloForm("helloForm", new Model<String>()));

        // ROBERT der true oder false zweig?
        if (true) {
            addFoobarTable();
        } else {
            add(new FoobarTable("foobarTable", new FoobarSortableDataProvider(repo)));
        }

    }

    private void addFoobarTable() {

        ISortableDataProvider<Foobar, String> dataProvider = new FoobarSortableDataProvider(repo);

        List<IColumn<Foobar, String>> columns = new ArrayList<>();
        columns.add(new PropertyColumn<Foobar, String>(new Model<String>(Foobar.PROPERTY_LDT),
                Foobar.PROPERTY_LDT, Foobar.PROPERTY_LDT));
        columns.add(new PropertyColumn<Foobar, String>(new Model<String>(Foobar.PROPERTY_I),
                Foobar.PROPERTY_I, Foobar.PROPERTY_I));

        DefaultDataTable<Foobar, String> table = new DefaultDataTable<>("foobarTable", columns,
                dataProvider, 10);

        add(table);

    }

}
