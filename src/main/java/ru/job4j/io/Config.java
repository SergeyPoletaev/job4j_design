package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String read = in.readLine();
            while (read != null) {
                if (!read.startsWith("#") && !read.isEmpty()) {
                    check(read);
                    String[] strings = read.split("=", 2);
                    if (!strings[0].isBlank() && !strings[1].isBlank()) {
                        values.put(strings[0], strings[1]);
                    }
                }
                read = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void check(String read) {
        if (!read.contains("=")
                || read.startsWith("=")
                || read.endsWith("=")) {
            throw new IllegalArgumentException();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("./data/app.properties");
        System.out.println(config);
    }
}
