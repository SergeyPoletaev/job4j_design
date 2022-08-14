package ru.job4j.dip.shop.store;

import ru.job4j.dip.shop.model.Check;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CheckStoreImpl implements CheckStore {
    private final Map<Integer, Check> checks = new HashMap<>();

    @Override
    public boolean add(Check check) {
        if (checks.containsKey(check.getId())) {
            return false;
        }
        return checks.put(check.getId(), check) == null;
    }

    @Override
    public boolean remove(int id) {
        return checks.remove(id) != null;
    }

    @Override
    public Optional<Check> findById(int id) {
        return checks.entrySet()
                .stream()
                .filter(e -> e.getKey() == id)
                .map(Map.Entry::getValue)
                .findFirst();
    }
}
