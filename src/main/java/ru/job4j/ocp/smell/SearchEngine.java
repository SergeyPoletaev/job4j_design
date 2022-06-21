package ru.job4j.ocp.smell;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Можно сделать метод findBy() более универсальным. Тогда нам не надо будет под изменяющиеся условия поиска
 * или под разные типы данных изменять существующий или плодить новые методы в этом классе нарушая ОСР.
 */
public class SearchEngine {

    /* первоначальный вариант */
    public String findBy(List<String> words, String key) {
        var rsl = "";
        for (var str : words) {
            if (str.contains(key)) {
                rsl = str;
            }
        }
        return rsl;
    }

    /* улучшенный вариант */
    public <T> List<T> findBy(List<T> elements, Predicate<T> pred) {
        List<T> rsl = new ArrayList<>();
        for (var el : elements) {
            if (pred.test(el)) {
                rsl.add(el);
            }
        }
        return rsl;
    }
}
