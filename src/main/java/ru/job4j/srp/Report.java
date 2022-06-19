package ru.job4j.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public interface Report {
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    String generate(Predicate<Employee> filter);
}
