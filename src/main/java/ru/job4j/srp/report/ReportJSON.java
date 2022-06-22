package ru.job4j.srp.report;

import com.google.gson.GsonBuilder;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.model.EmployeeTmp;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.transformer.Transformer;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportJSON implements Report {
    private final Store store;
    private final Transformer<EmployeeTmp, Employee> transformer;

    public ReportJSON(Store store, Transformer<EmployeeTmp, Employee> transformer) {
        this.store = store;
        this.transformer = transformer;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return store.findBy(filter).stream()
                .map(e -> new GsonBuilder().create().toJson(transformer.transform(e)))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
