package com.mercateo.foobar;

import org.apache.wicket.model.LoadableDetachableModel;

public class FoobarModel extends LoadableDetachableModel<Foobar> {

    private final FoobarDao repo;

    private final Integer id;

    public FoobarModel(FoobarDao repo, Foobar foo) {
        super(foo);
        this.repo = repo;
        this.id = foo.getI();
    }

    @Override
    protected Foobar load() {
        return repo.get(id);
    }

}
