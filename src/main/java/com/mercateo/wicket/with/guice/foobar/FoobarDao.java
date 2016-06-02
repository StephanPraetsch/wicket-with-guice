package com.mercateo.wicket.with.guice.foobar;

import java.util.Collection;

public interface FoobarDao {

    public Collection<Foobar> get();

    public Foobar get(Integer id);

}
