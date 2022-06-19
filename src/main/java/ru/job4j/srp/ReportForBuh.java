package ru.job4j.srp;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportForBuh implements Report {
    private final Store store;

    public ReportForBuh(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return store.findBy(filter).stream()
                .map(e -> e.getName() + "; "
                        + DATE_FORMAT.format(e.getHired().getTime()) + "; "
                        + DATE_FORMAT.format(e.getHired().getTime()) + "; "
                        + e.getSalary() + " RUR;" + System.lineSeparator())
                .collect(Collectors.joining("", "Name; Hired; Fired; Salary;" + System.lineSeparator(), ""));
    }
}
