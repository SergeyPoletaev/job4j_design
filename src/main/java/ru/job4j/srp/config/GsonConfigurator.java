package ru.job4j.srp.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.srp.adapter.CalendarAdapterJson;
import ru.job4j.srp.formatter.DateFormatter;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Supplier;

public class GsonConfigurator implements Supplier<Gson> {
    private final DateFormatter formatter;

    public GsonConfigurator(DateFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public Gson get() {
        return new GsonBuilder()
                .registerTypeAdapter(Calendar.class, new CalendarAdapterJson(formatter))
                .registerTypeAdapter(GregorianCalendar.class, new CalendarAdapterJson(formatter))
                .setPrettyPrinting()
                .create();
    }
}
