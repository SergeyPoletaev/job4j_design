package ru.job4j.lsp.foodstorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> container = new ArrayList<>();
    private double percent;

    @Override
    public boolean add(Food food) {
        boolean check = accept(food);
        if (check && percent <= Bound.SEVENTY_FIVE.getValue()) {
            container.add(food);
        } else if (check) {
            double currentPrice = food.getPrice().doubleValue();
            double newPrice = currentPrice - (currentPrice * food.getDiscount()) / 100;
            food.setPrice(new BigDecimal(newPrice));
            container.add(food);
        }
        return check;
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(container);
    }

    @Override
    public void clear() {
        container.clear();
    }

    @Override
    public boolean accept(Food food) {
        double percent = verification(food);
        boolean check = percent >= Bound.TWENTY_FIVE.getValue() && percent < Bound.ONE_HUNDRED.getValue();
        if (check) {
            this.percent = percent;
        }
        return check;
    }
}
