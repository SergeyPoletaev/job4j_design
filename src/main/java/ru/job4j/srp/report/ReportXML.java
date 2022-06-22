package ru.job4j.srp.report;

import ru.job4j.srp.model.Employee;
import ru.job4j.srp.model.EmployeeTmp;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.transformer.Transformer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {
    private final Store store;
    private final Transformer<EmployeeTmp, Employee> transformer;
    private final JAXBContext context;

    public ReportXML(Store store, Transformer<EmployeeTmp, Employee> transformer, JAXBContext context) {
        this.store = store;
        this.transformer = transformer;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        String xml = "";
        for (Employee em : employees) {
            EmployeeTmp employeeTmp = transformer.transform(em);
            try {
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                try (StringWriter writer = new StringWriter()) {
                    marshaller.marshal(employeeTmp, writer);
                    xml = writer.getBuffer().toString();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return xml;
    }
}
