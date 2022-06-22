package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.formatter.SimpleDateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.report.Report;
import ru.job4j.srp.report.ReportForBuh;
import ru.job4j.srp.store.MemStore;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportForBuhTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        DateFormatter formatter = new SimpleDateFormatter(new SimpleDateFormat("dd:MM:yyyy"));
        Report engine = new ReportForBuh(store, formatter);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(formatter.format(worker.getHired().getTime())).append("; ")
                .append(formatter.format(worker.getFired().getTime())).append("; ")
                .append(worker.getSalary()).append(" RUR;")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}