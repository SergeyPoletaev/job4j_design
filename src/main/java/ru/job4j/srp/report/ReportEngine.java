package ru.job4j.srp.report;

import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public class ReportEngine implements Report {
    private final Store store;
    private final DateFormatter formatter;

    public ReportEngine(Store store, DateFormatter formatter) {
        this.store = store;
        this.formatter = formatter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        String ln = System.lineSeparator();
        text.append("Name; Hired; Fired; Salary;").append(ln);
        for (Employee emp : store.findBy(filter)) {
            text.append(emp.getName()).append("; ")
                    .append(formatter.format(emp.getHired().getTime())).append("; ")
                    .append(formatter.format(emp.getFired().getTime())).append("; ")
                    .append(emp.getSalary()).append(";")
                    .append(ln);
        }
        return text.toString();
    }
}
