package ru.job4j.collections.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserProgram {

    public static void main(String[] args) {
        User userFirst = new User("Anna", 2, new GregorianCalendar(2000, Calendar.APRIL, 12));
        User userSecond = new User("Anna", 2, new GregorianCalendar(2000, Calendar.APRIL, 12));
        Map<User, Object> map = new HashMap<>();
        map.put(userFirst, new Object());
        map.put(userSecond, new Object());
        System.out.println(map);
    }
}
