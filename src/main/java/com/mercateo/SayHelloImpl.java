package com.mercateo;

public class SayHelloImpl implements SayHello {

    @Override
    public String hello(String s) {
        return "hello " + s;
    }

}
