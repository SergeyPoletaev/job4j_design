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
        String rsl = new ReportXML(store).generate(e -> true);
        StringBuilder sb = new StringBuilder();
        String ln = System.lineSeparator();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(ln)
                .append("<employee>").append(ln)
                .append("    <employees>").append(ln)
                .append("        <fired>").append(formatter.format(emp.getFired().getTime())).append("</fired>").append(ln)
                .append("        <hired>").append(formatter.format(emp.getHired().getTime())).append("</hired>").append(ln)
                .append("        <name>").append(emp.getName()).append("</name>").append(ln)
                .append("        <salary>").append(emp.getSalary()).append("</salary>").append(ln)
                .append("    </employees>").append(ln)
                .append("    <employees>").append(ln)
                .append("        <fired>").append(formatter.format(emp2.getFired().getTime())).append("</fired>").append(ln)
                .append("        <hired>").append(formatter.format(emp2.getHired().getTime())).append("</hired>").append(ln)
                .append("        <name>").append(emp2.getName()).append("</name>").append(ln)
                .append("        <salary>").append(emp2.getSalary()).append("</salary>").append(ln)
                .append("    </employees>").append(ln)
                .append("</employee>").append(ln);
        assertThat(rsl, is(sb.toString()));
    }
}