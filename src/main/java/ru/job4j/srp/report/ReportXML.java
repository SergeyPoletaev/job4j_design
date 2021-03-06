package ru.job4j.srp.report;

import ru.job4j.srp.config.JaxbConfigurator;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.model.Employees;
import ru.job4j.srp.store.Store;

import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements Report {
    private final Store store;
    private final Marshaller marshaller;

    public ReportXML(Store store, DateFormatter formatter) {
        this.store = store;
        this.marshaller = new JaxbConfigurator(formatter).get();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Employees employees = new Employees(store.findBy(filter));
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employees, writer);
            xml = writer.getBuffer().toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return xml;
    }
}
