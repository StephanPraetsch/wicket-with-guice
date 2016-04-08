package com.mercateo.wicket.with.guice.foobar;

import org.apache.wicket.model.LoadableDetachableModel;

public class FoobarModel extends LoadableDetachableModel<Foobar> {

    private final FoobarRepo repo;

    private final Integer id;

    public FoobarModel(FoobarRepo repo, Foobar foo) {
        super(foo);
        this.repo = repo;
        this.id = foo.getI();
    }

    @Override
    protected Foobar load() {
        return repo.get(id);
    }

}
