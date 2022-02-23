package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder sb = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                sb.append((char) read);
            }
            String[] strings = sb.toString().split(System.lineSeparator());
            for (String s : strings) {
                int num = Integer.parseInt(s);
                String rsl = num % 2 == 0 ? " - even number" : " - odd number";
                System.out.println(num + rsl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
