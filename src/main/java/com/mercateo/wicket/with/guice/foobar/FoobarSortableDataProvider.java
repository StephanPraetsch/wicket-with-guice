package com.mercateo.wicket.with.guice.foobar;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class FoobarSortableDataProvider extends SortableDataProvider<Foobar, String> {

    private final FoobarRepo repo;

    public FoobarSortableDataProvider(FoobarRepo repo) {
        this.repo = repo;
        setSort("ldt", SortOrder.ASCENDING);
    }

    @Override
    public Iterator<Foobar> iterator(long first, long count) {

        return repo.get().stream() //
                .sorted(new FoobarComparator(getSort())) //
                .skip(first) //
                .limit(count) //
                .iterator();

    }

    @Override
    public long size() {
        return repo.get().size();
    }

    @Override
    public IModel<Foobar> model(Foobar object) {
        // ROBERT ist das richtig so? dafür musste ich Foobar Serializable
        // machen
        return new Model<>(object);
    }

}
