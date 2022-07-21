package ru.job4j.isp.menu;

import java.util.Scanner;

public class TODOApp {
    private static final String SUCCUES = "Действие добавлено.";
    private static final String FAILURE = "Действие добавить не удалось!";
    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {
            String strMenu = """
                    ======= Меню ========
                    1. Добавить в корень
                    2. Добавить в предка
                    3. Показать список задач
                    4. Выход
                    =====================
                    """.trim();
            System.out.println(strMenu);
            System.out.println("Выберите номер действия ...");
            int num;
            try {
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Введенное значение должно быть числом!");
                continue;
            }
            switch (num) {
                case 1 -> {
                    System.out.println("======= Добавление в корень =======");
                    System.out.println("Введите название действия которое хотите добавить ...");
                    String nameAct = sc.nextLine();
                    System.out.println(menu.add(Menu.ROOT, nameAct, STUB_ACTION) ? SUCCUES : FAILURE);
                }
                case 2 -> {
                    System.out.println("======= Добавление в предка =======");
                    System.out.println("Введите название предка ...");
                    String parent = sc.nextLine();
                    System.out.println("Введите название действия которое необходимо добавить ...");
                    String child = sc.nextLine();
                    System.out.println(menu.add(parent, child, STUB_ACTION) ? SUCCUES : FAILURE);
                }
                case 3 -> {
                    System.out.println("======= Список задач пользователя =======");
                    new ConsolePrinter().print(menu);
                }
                case 4 -> {
                    flag = false;
                    System.out.println("Программа завершена, спасибо за внимание!");
                }
                default -> System.out.println("Выбранный пункт меню не существует!");
            }
        } while (flag);
    }
}
