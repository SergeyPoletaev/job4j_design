package ru.job4j.srp;

import java.io.File;

/**
 * Задача этого класса - это отправка оповещений.
 * Наличие в классе метода printInfo(User user), который не соответствует назначению класса,
 * нарушает принцип SRP.
 */
public class Sender {

    public boolean send(User user, File file) {
        /* логика отправки файла */
        return true;
    }

    public boolean send(User user, String msg) {
        /* логика отправки сообщения */
        return true;
    }

    public void printInfo(User user) {
        System.out.println(user.toString());
    }
}
