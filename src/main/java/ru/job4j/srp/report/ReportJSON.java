package ru.job4j.srp.report;

import com.google.gson.Gson;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final Gson gson;

    public ReportJSON(Store store, Gson gson) {
        this.store = store;
        this.gson = gson;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
