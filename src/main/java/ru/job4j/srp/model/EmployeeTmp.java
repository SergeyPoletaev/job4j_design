package ru.job4j.srp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeTmp {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String hired;
    @XmlAttribute
    private String fired;
    @XmlAttribute
    private int salary;

    public EmployeeTmp(String name, String hired, String fired, int salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public EmployeeTmp() {

    }
}
