package ru.job4j.io.serialization.json;

public class Group {
    private final String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Group{"
                + "name='" + name + '\''
                + '}';
    }
}
