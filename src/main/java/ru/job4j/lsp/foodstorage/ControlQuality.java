package ru.job4j.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
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
        List<Food> transit = new ArrayList<>();
        for (Store store : stores) {
            transit.addAll(store.findAll());
            store.clear();
        }
        for (Food food : transit) {
            redistribute(food);
        }
    }
}
