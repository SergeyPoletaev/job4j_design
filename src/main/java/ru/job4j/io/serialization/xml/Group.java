package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "group")
public class Group {
    @XmlAttribute
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public Group() {

    }

    @Override
    public String toString() {
        return "Group{"
                + "name='" + name + '\''
                + '}';
    }
}
