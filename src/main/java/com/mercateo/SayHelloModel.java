package com.mercateo;

import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.util.string.StringValue;

public class SayHelloModel extends LoadableDetachableModel<String> {

    private final SayHello say;

    private final StringValue pageParam;

    public SayHelloModel(SayHello say, StringValue pageParam) {
        this.say = say;
        this.pageParam = pageParam;
    }

    @Override
    protected String load() {
        return say.hello(pageParam.toString("john"));
    }

}
