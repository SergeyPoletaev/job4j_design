package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> values, Comparator<T> cmp) {
        return findBy(values, cmp, p -> p > 0);
    }

    public <T> T min(List<T> values, Comparator<T> cmp) {
        return findBy(values, cmp, p -> p < 0);

    }

    private <T> T findBy(List<T> values, Comparator<T> cmp, Predicate<Integer> predicate) {
        if (values.size() == 0) {
            throw new IllegalArgumentException("Размер списка должен быть больше нуля.");
        }
        T rsl = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            T el = values.get(i);
            if (predicate.test(cmp.compare(el, rsl))) {
                rsl = el;
            }
        }
        return rsl;
    }
}
