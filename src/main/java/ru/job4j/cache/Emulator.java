package ru.job4j.cache;

public class Emulator {

    public static void main(String[] args) {
        DirFileCache dir = new DirFileCache("./files/");
        System.out.println(dir.load("cars.txt"));
        System.out.println(dir.get("names.txt"));
        System.out.println(dir.get("names.txt"));
        System.out.println(dir.get("names.txt"));
        System.out.println(dir.get("addresses.txt"));
        System.out.println(dir.get("addresses.txt"));
        System.out.println(dir.get("addresses.txt"));
        System.out.println(dir.get("names.txt"));
        System.out.println(dir.get("addresses.txt"));
    }
}
