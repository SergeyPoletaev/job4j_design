package ru.job4j.question;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Set<Integer> idSet = previous.stream()
                .map(User::getId)
                .collect(Collectors.toSet());
        Set<User> currSet = new HashSet<>(current);
        currSet.removeAll(previous);
        int added = 0;
        int changed = 0;
        if (!currSet.isEmpty()) {
            for (var el : currSet) {
                if (idSet.contains(el.getId())) {
                    changed++;
                } else {
                    added++;
                }
            }
        }
        Set<User> prevSet = new HashSet<>(previous);
        int deleted = 0;
        prevSet.removeAll(current);
        if (!prevSet.isEmpty()) {
            deleted = prevSet.size() - changed;
        }
        return new Info(added, changed, deleted);
    }
}
