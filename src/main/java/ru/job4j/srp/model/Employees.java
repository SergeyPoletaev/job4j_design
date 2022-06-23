package ru.job4j.srp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    private List<Employee> employees;

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employees() {

    }
}
