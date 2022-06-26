package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.formatter.SimpleDateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.report.ReportXML;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReportXMLTest {

    @Test
    public void generate() {
        Calendar now = Calendar.getInstance();
        Employee emp = new Employee("anna", now, now, 100);
        Employee emp2 = new Employee("sveta", now, now, 200);
        Store store = new MemStore();
        store.add(emp);
        store.add(emp2);
        DateFormatter formatter = new SimpleDateFormatter(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        String hiredEmp = formatter.format(emp.getHired().getTime());
        String firedEmp = formatter.format(emp.getFired().getTime());
        String hiredEmp2 = formatter.format(emp2.getHired().getTime());
        String firedEmp2 = formatter.format(emp2.getFired().getTime());
        String rsl = new ReportXML(store, formatter).generate(e -> true);
        String exp = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee name="anna" hired="%s" fired="%s" salary="100"/>
                    <employee name="sveta" hired="%s" fired="%s" salary="200"/>
                </employees>
                """.formatted(hiredEmp, firedEmp, hiredEmp2, firedEmp2);
        assertThat(rsl, is(exp));
    }
}