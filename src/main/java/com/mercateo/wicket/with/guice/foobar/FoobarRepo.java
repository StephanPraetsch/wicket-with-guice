package com.mercateo.wicket.with.guice.foobar;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

import com.google.inject.Singleton;

@Singleton
public class FoobarRepo implements Supplier<Set<Foobar>> {

    private final Random r = new Random();

    private Set<Foobar> foobars = Collections.emptySet();

    public FoobarRepo() {
        fillRepo();
    }

    public void fillRepo() {
        foobars = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            LocalDateTime ldt = LocalDateTime.of(year(), month(), dayOfMonth(), hour(), minute());
            foobars.add(new Foobar(ldt, Integer.valueOf(i)));
        }
    }

    private int minute() {
        return r.nextInt(60);
    }

    private int hour() {
        return r.nextInt(24);
    }

    private int dayOfMonth() {
        return 1 + r.nextInt(28);
    }

    private Month month() {
        return Month.of(1 + r.nextInt(11));
    }

    private int year() {
        return 1900 + r.nextInt(200);
    }

    @Override
    public Set<Foobar> get() {
        return foobars;
    }

}
