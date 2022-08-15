package ru.job4j.lsp.foodstorage;

import java.util.List;

public class ControlQuality {
    private final List<Store> stores;
    private final TransitStore transit;

    public ControlQuality(List<Store> stores, TransitStore transit) {
        this.stores = stores;
        this.transit = transit;
    }

    public void redistribute(Food food) {
        for (Store store : stores) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }

    public void resort() {
        for (Store store : stores) {
            List<Food> foods = store.findAll();
            transit.addAll(foods);
            store.clear();
        }
        for (Food food : transit.findAll()) {
            redistribute(food);
        }
    }
}
