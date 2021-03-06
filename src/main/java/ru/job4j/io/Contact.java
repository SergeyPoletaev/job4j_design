package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");
        /*Запись во временный файл, который удалиться системой*/
        File tmpFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tmpFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }
        System.out.println(tmpFile);
        System.out.println("contact: " + contact);
        /*Чтение объекта из файла*/
        try (FileInputStream fis = new FileInputStream(tmpFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println("contactFromFile: " + contactFromFile);
        }
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }
}
