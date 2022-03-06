package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        if (args.length != 4) {
            String ln = System.lineSeparator();
            throw new IllegalArgumentException(
                    "Invalid number of arguments. Use the following arguments to start: " + ln
                            + "-path=source_file" + ln
                            + "-delimiter=pattern_delimiter" + ln
                            + "-out=stdout or output_file" + ln
                            + "-filter=pattern_filter" + ln
            );
        }
        Path path = Path.of(argsName.get("path"));
        if (!path.toFile().exists() || !path.toFile().isFile()) {
            throw new IllegalArgumentException("Argument path does not exist or not file");
        }
        handle(argsName);
    }

    public static void handle(ArgsName argsName) {
        List<String[]> list = new ArrayList<>();
        String delimiter = argsName.get("delimiter");
        try (Scanner sc = new Scanner(new FileInputStream(argsName.get("path")), StandardCharsets.UTF_8)
                .useDelimiter(delimiter + "|" + System.lineSeparator());
             FilterOutputStream fos =
                     "stdout".equals(argsName.get("out"))
                             ? System.out
                             : new BufferedOutputStream(new FileOutputStream(argsName.get("out")));
             PrintWriter out = new PrintWriter(fos, true, StandardCharsets.UTF_8)) {
            while (sc.hasNext()) {
                list.add(sc.nextLine().split(delimiter));
            }
            List<String> filters = Arrays.asList(argsName.get("filter").split(","));
            for (String[] strings : list) {
                StringJoiner sj = new StringJoiner(delimiter);
                for (int j = 0; j < strings.length; j++) {
                    if (filters.contains(list.get(0)[j])) {
                        sj.add(strings[j]);
                    }
                }
                out.println(sj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
