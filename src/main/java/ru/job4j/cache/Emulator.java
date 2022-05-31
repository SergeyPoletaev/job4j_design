package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {
        showMenu();
        getAction(new Scanner(System.in));
    }

    private static void showMenu() {
        String ln = System.lineSeparator();
        System.out.println(
                "Выберите необходимое действие:" + ln +
                        "1. Загрузить содержимое файла в кэш." + ln +
                        "2. Получить содержимое файла из кэша." + ln +
                        "3. Завершить программу" + ln + "================================");
    }

    private static void getAction(Scanner scanner) {
        boolean flag = true;
        String ln = System.lineSeparator();
        do {
            switch (validateAction(scanner)) {
                case 1 -> {
                    System.out.println("Содержимое загружено в кеш:"
                            + ln + new DirFileCache(inputDir(scanner)).load(inputFile(scanner)));
                    flag = false;
                }
                case 2 -> {
                    System.out.println("Содержимое получено из кеша:"
                            + ln + new DirFileCache(inputDir(scanner)).get(inputFile(scanner)));
                    flag = false;
                }
                case 3 -> {
                    System.out.println("Программа завершена.");
                    flag = false;
                }
                default -> System.out.println("Выбран не существующий пункт меню. Попробуйте еще раз.");
            }
        } while (flag);
    }


    private static String inputFile(Scanner scanner) {
        System.out.println("Укажите имя файла:");
        return scanner.nextLine();
    }

    private static String inputDir(Scanner scanner) {
        System.out.println("Укажите путь к кэшируемой директории:");
        return scanner.nextLine();
    }

    private static int validateAction(Scanner scanner) {
        boolean flag = true;
        int action = 0;
        do {
            try {
                action = Integer.parseInt(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Выбранное значение пункта меню не является числом. Попробуйте еще раз");
            }
        } while (flag);
        return action;
    }
}
