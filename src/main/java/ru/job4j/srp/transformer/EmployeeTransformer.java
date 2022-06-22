package ru.job4j.srp.transformer;

import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.model.EmployeeTmp;

public class EmployeeTransformer implements Transformer<EmployeeTmp, Employee> {
    private final DateFormatter formatter;

    public EmployeeTransformer(DateFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public EmployeeTmp transform(Employee emp) {
        return new EmployeeTmp(emp.getName(),
                formatter.format(emp.getHired().getTime()),
                formatter.format(emp.getFired().getTime()),
                emp.getSalary());
    }
}
