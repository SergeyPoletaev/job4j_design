package ru.job4j.collections.map;

import java.util.Calendar;
import java.util.Objects;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        int rsl = name.hashCode();
        rsl = 31 * rsl + Integer.hashCode(children);
        rsl = 31 * rsl + birthday.hashCode();
        return rsl;
    }
}
