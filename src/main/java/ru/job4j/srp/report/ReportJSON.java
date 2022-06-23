package ru.job4j.srp.report;

import com.google.gson.GsonBuilder;
import ru.job4j.srp.adapter.CalendarAdapterJson;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final DateFormatter formatter;

    public ReportJSON(Store store, DateFormatter formatter) {
        this.store = store;
        this.formatter = formatter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new GsonBuilder()
                .registerTypeAdapter(Calendar.class, new CalendarAdapterJson(formatter))
                .registerTypeAdapter(GregorianCalendar.class, new CalendarAdapterJson(formatter))
                .setPrettyPrinting()
                .create()
                .toJson(store.findBy(filter));
    }
}
