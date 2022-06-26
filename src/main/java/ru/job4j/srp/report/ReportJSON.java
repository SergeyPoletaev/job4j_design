package ru.job4j.srp.report;

import com.google.gson.Gson;
import ru.job4j.srp.config.GsonConfigurator;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final Gson gson;

    public ReportJSON(Store store, DateFormatter formatter) {
        this.store = store;
        this.gson = new GsonConfigurator(formatter).get();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
