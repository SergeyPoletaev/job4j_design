package ru.job4j.srp;

/**
 * Это модельный класс. Цель этого класса - это описание свойств объекта типа User.
 * В этом классе не должно быть ничего кроме полей, конструкторов, геттеров, сеттеров,
 * а также переопределенных методов из суперкласса Object.
 * Наличие метода access(String login, char[] password) нарушает принцип SRP.
 */
public class User {
    private final String name;
    private final int age;
    private final String phone;

    public User(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", phone='" + phone + '\''
                + '}';
    }

    public void access(String login, char[] password) {
        /* логика получения доступа */
    }
}
