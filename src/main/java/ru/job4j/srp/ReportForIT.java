package ru.job4j.srp;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportForIT implements Report {
    private final Store store;

    public ReportForIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return store.findBy(filter).stream()
                .map(e -> "<p>" + e.getName() + "; " + e.getHired() + "; " + e.getHired() + "; " + e.getSalary() + ";" + "</p>" + System.lineSeparator())
                .collect(Collectors.joining("", "<p>Name; Hired; Fired; Salary;</p>" + System.lineSeparator(), ""));
    }
}
