package ru.job4j.isp.smell.example3;

import java.util.List;

public class AutoService implements Service {

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

    @Override
    public boolean tireFitting(Vehicle v, Tire tire) {
        /* tire fitting logic */
        return false;
    }

    /**
     * AutoService не поддерживает этот функционал, не правильно выделена абстракция. Нарушен ISP.
     * Кроме того логику этой функции предназначенной специально для лодок по сути можно реализовать в методе
     * tuning(Vehicle v, Order order). А если по каким-то причинам нельзя/не удлобно, то тогда нужно разделить
     * интерфейсы.
     */
    @Override
    public boolean anchorSystemInstallation(Vehicle v, Order order) {
        throw new UnsupportedOperationException();
    }
}
