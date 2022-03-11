package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private boolean status;
    @XmlElement(name = "group")
    private Group group;
    @XmlElementWrapper(name = "documentes")
    @XmlElement(name = "documents")
    private String[] documents;

    public Student() {

    }

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
