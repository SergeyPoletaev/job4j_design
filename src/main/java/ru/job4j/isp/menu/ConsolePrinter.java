package ru.job4j.isp.menu;

public class ConsolePrinter implements MenuPrinter {
    private static final String PREFIX = "---";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo itemInfo : menu) {
            int num = itemInfo.getNumber().split("\\.").length;
            String base = itemInfo.getNumber() + itemInfo.getName();
            String result = num == 1 ? base : PREFIX.repeat(num) + base;
            System.out.println(result);
        }
    }
}
