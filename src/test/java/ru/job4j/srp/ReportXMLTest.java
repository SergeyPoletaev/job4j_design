package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.formatter.SimpleDateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.model.EmployeeTmp;
import ru.job4j.srp.report.ReportXML;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.transformer.EmployeeTransformer;
import ru.job4j.srp.transformer.Transformer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReportXMLTest {

    @Test
    public void generate() throws JAXBException {
        Calendar now = Calendar.getInstance();
        Employee emp = new Employee("anna", now, now, 100);
        Store store = new MemStore();
        store.add(emp);
        DateFormatter formatter = new SimpleDateFormatter(new SimpleDateFormat("dd:MM:yyyy"));
        Transformer<EmployeeTmp, Employee> transformer = new EmployeeTransformer(formatter);
        JAXBContext context = JAXBContext.newInstance(EmployeeTmp.class);
        String rsl = new ReportXML(store, transformer, context).generate(e -> true);
        String exp = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employee name=\"" + emp.getName()
                + "\" hired=\"" + formatter.format(emp.getHired().getTime())
                + "\" fired=\"" + formatter.format(emp.getFired().getTime())
                + "\" salary=\"" + emp.getSalary() + "\"/>" + System.lineSeparator();
        assertThat(rsl, is(exp));
    }
}