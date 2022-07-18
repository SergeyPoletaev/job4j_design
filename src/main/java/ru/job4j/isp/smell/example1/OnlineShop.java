package ru.job4j.isp.smell.example1;

public class OnlineShop implements Shop {

    @Override
    public boolean sell(Product product) {
        /* product selling logic ... */
        return false;
    }

    @Override
    public boolean deliver(Product product) {
        /* product delivering logic ... */
        return false;
    }
}
