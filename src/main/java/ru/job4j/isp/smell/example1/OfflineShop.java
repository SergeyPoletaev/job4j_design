package ru.job4j.isp.smell.example1;

public class OfflineShop implements Shop {

    @Override
    public boolean sell(Product product) {
        /* product selling logic ... */
        return false;
    }

    /**
     * Класс не должен зависить от методов которые не поддерживаются.
     * Нарушен ISP, не правильно выделена абстракция.
     * Нужно в интерфейсе Shop оставить только один метод sell(Product p), определить еще один интерфейс DeliveryShop
     * c абстрактным методом deliver(Product p) и унаследовать интерфейс Shop.
     * Реализация DeliveryShop будет OnlineShop, реализация Shop будет Offlineshop.
     */
    @Override
    public boolean deliver(Product product) {
        throw new UnsupportedOperationException();
    }
}
