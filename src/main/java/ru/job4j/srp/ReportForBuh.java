package ru.job4j.srp;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportForBuh implements Report {
    private final Store store;
    private final DateFormatter formatter;


    public ReportForBuh(Store store, DateFormatter formatter) {
        this.store = store;
        this.formatter = formatter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return store.findBy(filter).stream()
                .map(e -> e.getName() + "; "
                        + formatter.format(e.getHired().getTime()) + "; "
                        + formatter.format(e.getHired().getTime()) + "; "
                        + e.getSalary() + " RUR;" + System.lineSeparator())
                .collect(Collectors.joining("", "Name; Hired; Fired; Salary;" + System.lineSeparator(), ""));
    }
}
