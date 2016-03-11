package com.mercateo.wicket.with.guice.foobar;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;

public class FoobarTable extends DefaultDataTable<Foobar, String> {

    public FoobarTable(String id, ISortableDataProvider<Foobar, String> dataProvider) {
        super(id, columns(), dataProvider, 10);
    }

    private static List<IColumn<Foobar, String>> columns() {

        List<IColumn<Foobar, String>> columns = new ArrayList<>();

        // ROBERT wofür sind die 3 felder?
        columns.add(new PropertyColumn<Foobar, String>( //
                new Model<String>(Foobar.PROPERTY_LDT), Foobar.PROPERTY_LDT, Foobar.PROPERTY_LDT));

        columns.add(new PropertyColumn<Foobar, String>( //
                new Model<String>(Foobar.PROPERTY_I), Foobar.PROPERTY_I, Foobar.PROPERTY_I));

        return columns;

    }

}
