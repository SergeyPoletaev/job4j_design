package ru.job4j.srp.config;

import ru.job4j.srp.adapter.CalendarAdapterXml;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.model.Employees;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.function.Supplier;

public class JaxbConfigurator implements Supplier<Marshaller> {
    private final DateFormatter formatter;

    public JaxbConfigurator(DateFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public Marshaller get() {
        Marshaller marshaller = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setAdapter(new CalendarAdapterXml(formatter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marshaller;
    }
}
