package com.mercateo.wicket.with.guice.foobar;

import java.time.LocalDateTime;

public class Foobar {

    public static final String PROPERTY_LDT = "ldt";

    public static final String PROPERTY_I = "i";

    private final LocalDateTime ldt;

    private final Integer i;

    public Foobar(LocalDateTime ldt, Integer i) {
        this.ldt = ldt;
        this.i = i;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public Integer getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Foobar [ldt=" + ldt + ", i=" + i + "]";
    }

}
