package com.mercateo.wicket.with.guice.foobar;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

public class FoobarSortableDataProvider extends SortableDataProvider<Foobar, String> {

    private final FoobarDao dao;

    public FoobarSortableDataProvider(FoobarDao dao) {
        this.dao = dao;
        setSort(Foobar.PROPERTY_LDT, SortOrder.ASCENDING);
    }

    @Override
    public Iterator<Foobar> iterator(long first, long count) {

        return dao.get().stream() //
                .sorted(new FoobarComparator(getSort())) //
                .skip(first) //
                .limit(count) //
                .iterator();

    }

    @Override
    public long size() {
        return dao.get().size();
    }

    @Override
    public IModel<Foobar> model(Foobar object) {
        return new FoobarModel(dao, object);
    }

}
