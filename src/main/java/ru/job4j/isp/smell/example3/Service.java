package ru.job4j.isp.smell.example3;

import java.util.List;

public interface Service {

    List<Result> diagnostics(Vehicle v);

    boolean repair(Vehicle v, List<Result> results);

    void tuning(Vehicle v, Order order);

    boolean maintenance(Vehicle v);

    boolean tireFitting(Vehicle v, Tire tire);

    boolean anchorSystemInstallation(Vehicle v, Order order);
}
