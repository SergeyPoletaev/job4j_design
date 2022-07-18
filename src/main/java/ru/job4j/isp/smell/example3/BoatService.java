package ru.job4j.isp.smell.example3;

import java.util.List;

public class BoatService implements Service {

    @Override
    public List<Result> diagnostics(Vehicle v) {
        /* diagnostics logic */
        return null;
    }

    @Override
    public boolean repair(Vehicle v, List<Result> results) {
        /* repair logic */
        return false;
    }

    @Override
    public void tuning(Vehicle v, Order order) {
        /* tuning logic */
    }

    @Override
    public boolean maintenance(Vehicle v) {
        /* maintenance logic */
        return false;
    }

    /**
     * BoatService не поддерживает этот функционал, не правильно выделена абстракция. Нарушен ISP.
     * Нужно разделить интерфейс Service выделив из него общий, который подходит "для всех" и специализированные, в
     * данном случае для наземного и водного транспорта. Специализированные интерфейсы должны унаследовать общий, и
     * реализации уже делать от специализированных интерфейсов.
     */
    @Override
    public boolean tireFitting(Vehicle v, Tire tire) {
        /* tireFitting logic */
        return false;
    }

    @Override
    public boolean anchorSystemInstallation(Vehicle v, Order order) {
        /* anchor system installation logic. */
        return false;
    }
}
