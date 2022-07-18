package ru.job4j.isp.smell.example2;

import java.math.BigDecimal;

public interface Payment {

    boolean pay(Order order);

    BigDecimal cashback(Order order);

    boolean cancel(Transaction t);
}