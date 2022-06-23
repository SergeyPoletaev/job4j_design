package ru.job4j.srp.adapter;

import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.formatter.SimpleDateFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapterXml extends XmlAdapter<String, Calendar> {
    private static final DateFormatter FORMATTER = new SimpleDateFormatter(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));

    @Override
    public Calendar unmarshal(String s) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public String marshal(Calendar calendar) throws Exception {
        return FORMATTER.format(calendar.getTime());
    }
}
