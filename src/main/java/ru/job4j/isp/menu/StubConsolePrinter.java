package ru.job4j.isp.menu;

import java.util.StringJoiner;

public class StubConsolePrinter implements MenuPrinter {
    private final StringJoiner buffer = new StringJoiner(System.lineSeparator());

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo itemInfo : menu) {
            int num = itemInfo.getNumber().split("\\.").length;
            String prefix = "---";
            String base = itemInfo.getNumber() + itemInfo.getName();
            String result = num == 1 ? base : prefix.repeat(num) + base;
            buffer.add(result);
        }
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
