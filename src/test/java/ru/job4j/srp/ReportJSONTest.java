package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.formatter.SimpleDateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.model.EmployeeTmp;
import ru.job4j.srp.report.ReportJSON;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.transformer.EmployeeTransformer;
import ru.job4j.srp.transformer.Transformer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReportJSONTest {

    @Test
    public void generate() {
        Calendar now = Calendar.getInstance();
        Employee emp = new Employee("anna", now, now, 100);
        Store store = new MemStore();
        store.add(emp);
        DateFormatter formatter = new SimpleDateFormatter(new SimpleDateFormat("dd:MM:yyyy"));
        Transformer<EmployeeTmp, Employee> transformer = new EmployeeTransformer(formatter);
        String rsl = new ReportJSON(store, transformer).generate(e -> true);
        String exp = "{"
                + "\"" + "name\":\"" + emp.getName() + "\"" + ","
                + "\"" + "hired\":\"" + formatter.format(emp.getHired().getTime()) + "\"" + ","
                + "\"" + "fired\":\"" + formatter.format(emp.getFired().getTime()) + "\"" + ","
                + "\"" + "salary\":" + emp.getSalary()
                + "}";
        assertThat(rsl, is(exp));
    }
}