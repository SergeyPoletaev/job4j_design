package ru.job4j.gc;

public class User {
    private final String name;
    private final int age;
    private final boolean status;

    public User(String name, int age, boolean status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    @Override
    protected void finalize() {
        System.out.printf("Removed %s %d %b%n", name, age, status);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isStatus() {
        return status;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7600; i++) {
            new User("UserName" + i, i, true);
            System.out.println("создан" + i);
        }
    }
}
