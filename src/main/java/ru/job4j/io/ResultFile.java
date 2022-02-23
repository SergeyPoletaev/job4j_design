package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResultFile {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    String str = i + " * " + j + " = " + i * j + System.lineSeparator();
                    out.write(str.getBytes(StandardCharsets.UTF_8));
                    if (j == 10) {
                        out.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
                    }
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
