package ru.job4j.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportEngine implements Report {
    public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    private final Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        String ln = System.lineSeparator();
        text.append("Name; Hired; Fired; Salary;").append(ln);
        for (Employee emp : store.findBy(filter)) {
            text.append(emp.getName()).append("; ")
                    .append(DATE_FORMAT.format(emp.getHired().getTime())).append("; ")
                    .append(DATE_FORMAT.format(emp.getFired().getTime())).append("; ")
                    .append(emp.getSalary()).append(";")
                    .append(ln);
        }
        return text.toString();
    }
}
