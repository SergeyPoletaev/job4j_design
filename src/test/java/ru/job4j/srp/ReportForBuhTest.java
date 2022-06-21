package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.job4j.srp.ReportForBuh.DATE_FORMAT;

public class ReportForBuhTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForBuh(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append("; ")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append("; ")
                .append(worker.getSalary()).append(" RUR;")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}