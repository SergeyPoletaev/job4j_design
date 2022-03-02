package ru.job4j.io;

import java.io.File;

public class Dir {

    public static void main(String[] args) {
        File file = new File("c:/projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("File not exist: %s", file.getAbsolutePath()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("File not directory: %s", file.getAbsolutePath()));
        }
        System.out.printf("size: %s%n", file.getTotalSpace());
        for (File subFile : file.listFiles()) {
            if (subFile.isFile()) {
                System.out.println(subFile.getName() + " : " + subFile.length());
            }
        }
    }
}
