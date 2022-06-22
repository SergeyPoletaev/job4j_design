package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.report.ReportForHR;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportForHRTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("anna", now, now, 200);
        Employee worker2 = new Employee("nik", now, now, 100);
        Employee worker3 = new Employee("peter", now, now, 300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        String rsl = new ReportForHR(store).generate(e -> true);
        String ln = System.lineSeparator();
        StringBuilder exp = new StringBuilder()
                .append("Name; ").append("Salary;").append(ln)
                .append(worker3.getName()).append("; ").append(worker3.getSalary()).append(";").append(ln)
                .append(worker1.getName()).append("; ").append(worker1.getSalary()).append(";").append(ln)
                .append(worker2.getName()).append("; ").append(worker2.getSalary()).append(";").append(ln);
        assertThat(rsl, is(exp.toString()));
    }
}