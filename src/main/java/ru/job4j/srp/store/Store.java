package ru.job4j.srp.store;

import ru.job4j.srp.model.Employee;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Employee> findBy(Predicate<Employee> filter);

    void add(Employee employee);
}
