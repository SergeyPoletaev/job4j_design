package ru.job4j.srp.report;

import com.google.gson.GsonBuilder;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new GsonBuilder().create().toJson(store.findBy(filter));
    }
}
