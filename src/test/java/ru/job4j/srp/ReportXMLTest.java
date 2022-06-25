package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.config.JaxbConfigurator;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.formatter.SimpleDateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.report.ReportXML;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;

import javax.xml.bind.Marshaller;
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
        Marshaller marshaller = new JaxbConfigurator(formatter).get();
        String rsl = new ReportXML(store, marshaller).generate(e -> true);
        String ln = System.lineSeparator();
        StringBuilder sb = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(ln)
                .append("<employees>").append(ln)
                .append("    <employee")
                .append(" name=\"").append(emp.getName()).append("\"")
                .append(" hired=\"").append(formatter.format(emp.getHired().getTime())).append("\"")
                .append(" fired=\"").append(formatter.format(emp.getFired().getTime())).append("\"")
                .append(" salary=\"").append(emp.getSalary()).append("\"/>").append(ln)
                .append("    <employee")
                .append(" name=\"").append(emp2.getName()).append("\"")
                .append(" hired=\"").append(formatter.format(emp2.getHired().getTime())).append("\"")
                .append(" fired=\"").append(formatter.format(emp2.getFired().getTime())).append("\"")
                .append(" salary=\"").append(emp2.getSalary()).append("\"/>").append(ln)
                .append("</employees>").append(ln);
        assertThat(rsl, is(sb.toString()));
    }
}