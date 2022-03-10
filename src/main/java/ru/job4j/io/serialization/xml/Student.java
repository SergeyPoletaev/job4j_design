package ru.job4j.io.serialization.xml;

import java.util.Arrays;

public class Student {
    private final String name;
    private final int age;
    private final boolean status;
    private final Group group;
    private final String[] documents;

    public Student(String name, int age, boolean status, Group group, String[] documents) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.group = group;
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", status=" + status
                + ", group=" + group
                + ", documents=" + Arrays.toString(documents)
                + '}';
    }
}
