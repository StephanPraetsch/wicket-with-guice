package com.mercateo.wicket.with.guice.foobar;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.inject.Singleton;

@Singleton
public class FoobarRepo implements FoobarDao {

    private final Random r = new Random();

    private Map<Integer, Foobar> foobars = Collections.emptyMap();

    public FoobarRepo() {
        fillRepo();
    }

    public void fillRepo() {
        foobars = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            LocalDateTime ldt = LocalDateTime.of(year(), month(), dayOfMonth(), hour(), minute());
            foobars.put(Integer.valueOf(i), new Foobar(ldt, Integer.valueOf(i)));
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
    public Collection<Foobar> get() {
        return foobars.values();
    }

    @Override
    public Foobar get(Integer id) {
        return foobars.get(id);
    }

}
