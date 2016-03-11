package com.mercateo.wicket.with.guice.foobar;

import java.util.Set;

import org.apache.wicket.model.LoadableDetachableModel;

// ROBERT unbenutzt, würdest du das so nutzen? wie?
public class FoobarModel extends LoadableDetachableModel<Set<Foobar>> {

    private final FoobarRepo repo;

    public FoobarModel(FoobarRepo repo) {
        this.repo = repo;
    }

    @Override
    protected Set<Foobar> load() {
        return repo.get();
    }

}
