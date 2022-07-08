package ru.job4j.lsp.foodstorage;

import java.math.BigDecimal;

public class ControlQuality {
    private final Store warehause;
    private final Store shop;
    private final Store trash;
    private long currentTime;

    public ControlQuality(Store warehause, Store shop, Store trash) {
        this.warehause = warehause;
        this.shop = shop;
        this.trash = trash;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void redistribute(Food food) {
        double percent = verification(food);
        if (percent < 25) {
            warehause.add(food);
        } else if (percent >= 25 && percent <= 75) {
            shop.add(food);
        } else if (percent > 75 && percent < 100) {
            double newPrice = food.getPrice().doubleValue() - (food.getPrice().doubleValue() * food.getDiscount()) / 100;
            food.setPrice(new BigDecimal(newPrice));
            shop.add(food);
        } else {
            trash.add(food);
        }
    }

    private double verification(Food food) {
        long currentTime = this.currentTime == 0 ? System.currentTimeMillis() : this.currentTime;
        long productLifeTime = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long productAge = currentTime - food.getCreateDate().getTimeInMillis();
        return (double) productAge * 100 / productLifeTime;
    }
}
