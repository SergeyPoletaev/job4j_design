package ru.job4j.srp.adapter;

import ru.job4j.srp.formatter.DateFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Calendar;

public class CalendarAdapterXml extends XmlAdapter<String, Calendar> {
    private final DateFormatter formatter;

    public CalendarAdapterXml(DateFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public Calendar unmarshal(String s) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public String marshal(Calendar calendar) throws Exception {
        return formatter.format(calendar.getTime());
    }
}
