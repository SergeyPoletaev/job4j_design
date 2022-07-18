package ru.job4j.isp.smell.example2;

import java.math.BigDecimal;

public class MirPay implements Payment {

    @Override
    public boolean pay(Order order) {
        /* pay logic */
        return false;
    }

    @Override
    public BigDecimal cashback(Order order) {
        /* cashback logic */
        return null;
    }

    @Override
    public boolean cancel(Transaction t) {
        /* cancel logic */
        return false;
    }
}
