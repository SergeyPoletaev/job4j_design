package ru.job4j.io;

import java.io.*;

public class Analize {

    public static void main(String[] args) {
        Analize analize = new Analize();
        analize.unavailable("./data/server.log", "./data/unavailable.csv");
    }

    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean flag = false;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] str = line.split(" ");
                if (("400".equals(str[0]) || "500".equals(str[0])) && !flag) {
                    out.print(str[1] + ";");
                    flag = true;
                } else if (("200".equals(str[0]) || "300".equals(str[0])) && flag) {
                    out.println(str[1]);
                    flag = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
