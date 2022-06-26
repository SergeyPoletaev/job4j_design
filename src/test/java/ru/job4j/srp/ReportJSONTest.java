package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.formatter.SimpleDateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.report.ReportJSON;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReportJSONTest {

    @Test
    public void generate() {
        Calendar now = Calendar.getInstance();
        Employee emp = new Employee("anna", now, now, 100);
        Employee emp2 = new Employee("sveta", now, now, 200);
        Store store = new MemStore();
        store.add(emp);
        store.add(emp2);
        DateFormatter formatter = new SimpleDateFormatter(new SimpleDateFormat("dd:MM:yyyy"));
        String hiredEmp = formatter.format(emp.getHired().getTime());
        String firedEmp = formatter.format(emp.getFired().getTime());
        String hiredEmp2 = formatter.format(emp2.getHired().getTime());
        String firedEmp2 = formatter.format(emp2.getFired().getTime());
        String rsl = new ReportJSON(store, formatter).generate(e -> true);
        String exp = """
                [
                  {
                    "name": "anna",
                    "hired": "%s",
                    "fired": "%s",
                    "salary": 100
                  },
                  {
                    "name": "sveta",
                    "hired": "%s",
                    "fired": "%s",
                    "salary": 200
                  }
                ]
                """.formatted(hiredEmp, firedEmp, hiredEmp2, firedEmp2).trim();
        assertThat(rsl, is(exp));
    }
}