package ru.job4j.lsp.foodstorage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class Food {
    private final String name;
    private final Calendar createDate;
    private final Calendar expiryDate;
    private BigDecimal price;
    private final int discount;

    public Food(String name, Calendar createDate, Calendar expiryDate, BigDecimal price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return discount == food.discount && Objects.equals(name, food.name)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expiryDate, food.expiryDate)
                && Objects.equals(price, food.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expiryDate, price, discount);
    }
}
