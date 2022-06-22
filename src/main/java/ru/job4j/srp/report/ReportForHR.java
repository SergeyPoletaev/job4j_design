package ru.job4j.srp.report;

import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportForHR implements Report {
    private final Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return store.findBy(filter).stream()
                .sorted(Comparator.comparing(Employee::getSalary, (o2, o1) -> Integer.compare(o1, o2)))
                .map(e -> e.getName() + "; " + e.getSalary() + ";" + System.lineSeparator())
                .collect(Collectors.joining("", "Name; Salary;" + System.lineSeparator(), ""));
    }
}
