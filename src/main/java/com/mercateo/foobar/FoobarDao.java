package com.mercateo.foobar;

import java.util.Collection;

public interface FoobarDao {

    public Collection<Foobar> get();

    public Foobar get(Integer id);

}
