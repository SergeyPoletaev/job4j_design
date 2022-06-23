package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.report.ReportJSON;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;

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
        String rsl = new ReportJSON(store).generate(e -> true);
        StringBuilder sb = new StringBuilder();
        sb.append("[{")
                .append("\"name\":\"").append(emp.getName()).append("\"").append(",")
                .append("\"hired\":{\"")
                .append("year\":").append(emp.getHired().getTime().getYear() + 1900).append(",")
                .append("\"month\":").append(emp.getHired().getTime().getMonth()).append(",")
                .append("\"dayOfMonth\":").append(emp.getHired().getTime().getDate()).append(",")
                .append("\"hourOfDay\":").append(emp.getHired().getTime().getHours()).append(",")
                .append("\"minute\":").append(emp.getHired().getTime().getMinutes()).append(",")
                .append("\"second\":").append(emp.getHired().getTime().getSeconds())
                .append("}").append(",")
                .append("\"fired\":{")
                .append("\"year\":").append(emp.getFired().getTime().getYear() + 1900).append(",")
                .append("\"month\":").append(emp.getFired().getTime().getMonth()).append(",")
                .append("\"dayOfMonth\":").append(emp.getFired().getTime().getDate()).append(",")
                .append("\"hourOfDay\":").append(emp.getFired().getTime().getHours()).append(",")
                .append("\"minute\":").append(emp.getFired().getTime().getMinutes()).append(",")
                .append("\"second\":").append(emp.getFired().getTime().getSeconds())
                .append("}").append(",")
                .append("\"salary\":").append(emp.getSalary()).append("}")
                .append(",").append("{")
                .append("\"name\":\"").append(emp2.getName()).append("\"").append(",")
                .append("\"hired\":{\"")
                .append("year\":").append(emp2.getHired().getTime().getYear() + 1900).append(",")
                .append("\"month\":").append(emp2.getHired().getTime().getMonth()).append(",")
                .append("\"dayOfMonth\":").append(emp2.getHired().getTime().getDate()).append(",")
                .append("\"hourOfDay\":").append(emp2.getHired().getTime().getHours()).append(",")
                .append("\"minute\":").append(emp2.getHired().getTime().getMinutes()).append(",")
                .append("\"second\":").append(emp2.getHired().getTime().getSeconds())
                .append("}").append(",")
                .append("\"fired\":{")
                .append("\"year\":").append(emp2.getFired().getTime().getYear() + 1900).append(",")
                .append("\"month\":").append(emp2.getFired().getTime().getMonth()).append(",")
                .append("\"dayOfMonth\":").append(emp2.getFired().getTime().getDate()).append(",")
                .append("\"hourOfDay\":").append(emp2.getFired().getTime().getHours()).append(",")
                .append("\"minute\":").append(emp2.getFired().getTime().getMinutes()).append(",")
                .append("\"second\":").append(emp2.getFired().getTime().getSeconds())
                .append("}").append(",")
                .append("\"salary\":").append(emp2.getSalary())
                .append("}]");
        assertThat(rsl, is(sb.toString()));
    }
}