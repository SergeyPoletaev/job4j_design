package ru.job4j.srp.formatter;

import java.text.DateFormat;
import java.util.Date;

public class SimpleDateFormatter implements DateFormatter {
    private final DateFormat dateFormat;

    public SimpleDateFormatter(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String format(Date date) {
        return dateFormat.format(date);
    }
}
