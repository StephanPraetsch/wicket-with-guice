package com.mercateo.wicket.with.guice.foobar;

import java.util.Comparator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

public class FoobarComparator implements Comparator<Foobar> {

    private final SortParam<String> sort;

    public FoobarComparator(SortParam<String> sort) {
        this.sort = sort;
    }

    @Override
    public int compare(Foobar o1, Foobar o2) {

        String property = sort.getProperty();

        int compare = 0;

        if (property.equals(Foobar.PROPERTY_LDT)) {
            compare = o1.getLdt().compareTo(o2.getLdt());
        } else if (property.equals(Foobar.PROPERTY_I)) {
            compare = o1.getI().compareTo(o2.getI());
        } else {
            throw new RuntimeException("unknow property: " + property);
        }

        if (sort.isAscending()) {
            compare = -compare;
        }

        return compare;

    }

}
