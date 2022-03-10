package ru.job4j.io.serialization.xml;

public class Group {
    private final String name;

    public Group(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{"
                + "name='" + name + '\''
                + '}';
    }
}
