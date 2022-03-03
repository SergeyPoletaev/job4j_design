package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public static ArgsName of(String[] args) {
        ArgsName argsName = new ArgsName();
        argsName.parse(args);
        return argsName;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("The argument is not found");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (var str : args) {
            String[] tmp = str.split("=", 2);
            if (tmp.length != 2
                    || !tmp[0].startsWith("-")
                    || tmp[0].length() < 2
                    || tmp[0].substring(1).isBlank()
                    || tmp[1].isBlank()) {
                throw new IllegalArgumentException("Invalid format of arguments");
            }
            values.put(tmp[0].substring(1), tmp[1]);
        }
    }
}
