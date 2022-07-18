package ru.job4j.isp.smell.example2;

import java.math.BigDecimal;

public class UnionPay implements Payment {

    @Override
    public boolean pay(Order order) {
        /* pay logic */
        return false;
    }

    /**
     * В методе вместо логики заглушка. Нет такого функционала у класса UnionPay.
     * Не правильно выделена абстракция, нарушен ISP.
     */
    @Override
    public BigDecimal cashback(Order order) {
        return null;
    }

    @Override
    public boolean cancel(Transaction t) {
        /* cancel logic */
        return false;
    }
}
