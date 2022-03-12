package ru.job4j.io.search;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchFileProgram {

    /**
     * Программа для поиска файла.
     * Программа ищет данные в заданном каталоге и подкаталогах.
     * Имя файла может задаваться, целиком, по маске, по регулярному выражению.
     * Программа собирается в jar и запускается через:
     * java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt
     * Ключи
     * -d - директория, в которой начинать поиск.
     * -n - имя файла (name), маска(mask), либо регулярное выражение(regex).
     * -t - тип поиска:
     * --- mask искать по маске:
     * ------ * - ищет все файлы,
     * ------ *abc - шщет файлы которые заканчиваются на abc,
     * ------ abc* - ищет файлы которые начинаются с abc.
     * --- name по полному совпадение имени,
     * --- regex по регулярному выражению.
     * -o - результат записать в файл.
     * Программа записывает результат в файл.
     */
    public static void main(String[] args) throws IOException {
        if (!(args.length == 4)) {
            String ln = System.lineSeparator();
            throw new IllegalArgumentException(
                    "Invalid number of arguments. Use the following arguments to start: " + ln
                            + "-d=source_directory" + ln
                            + "-n=file_name, mask, or regular expression" + ln
                            + "-t=search_type: mask search by mask, name on complete name, regex on regular study" + ln
                            + "-o=output_file"
            );
        }
        ArgsName argsName = ArgsName.of(args);
        Path dir = Path.of(argsName.get("d"));
        if (!dir.toFile().exists() || !dir.toFile().isDirectory()) {
            throw new IllegalArgumentException("Source directory does not exist");
        }
        String searchType = argsName.get("t");
        if (!"mask".equals(searchType) && !"name".equals(searchType) && !"regex".equals(searchType)) {
            throw new IllegalArgumentException(
                    "Not the correct key parameter -t. Use the following key settings: mask, name, regex."
            );
        }
        String searchKey = argsName.get("n");
        if ("mask".equals(searchType) && !searchKey.startsWith("*") && !searchKey.endsWith("*")) {
            String ln = System.lineSeparator();
            throw new IllegalArgumentException(
                    "Not the correct key parameter -n. " + ln
                            + "When using -n=mask, the value of the key -t must match the template: " + ln
                            + "* - to search for all files in the source directory" + ln
                            + "*abc - to search for all files whose name ends on abc" + ln
                            + "abc* - to search for all files whose name starts with abc"
            );
        }
        List<Path> results = search(dir, searchKey, searchType);
        Path target = Path.of(argsName.get("o"));
        writeResult(results, target);
    }

    private static List<Path> search(Path sourceDir, String searchKey, String searchType) throws IOException {
        Map<String, Predicate<Path>> map = getPredicateMap(searchKey);
        SearchFiles searcher = new SearchFiles(map.get(searchType));
        Files.walkFileTree(sourceDir, searcher);
        return searcher.getPaths();
    }

    private static Map<String, Predicate<Path>> getPredicateMap(String searchKey) {
        Predicate<Path> name = p -> p.toFile().getName().equals(searchKey);
        Predicate<Path> mask = p -> {
            boolean rsl = false;
            if (searchKey.startsWith("*")) {
                rsl = p.toFile().getName().endsWith(searchKey.substring(1));
            } else if (searchKey.endsWith("*")) {
                rsl = p.toFile().getName().startsWith(searchKey.substring(0, searchKey.length() - 1));
            }
            return rsl;
        };
        Predicate<Path> regex = p -> Pattern.matches(searchKey, p.toFile().getName());
        return new HashMap<>(Map.of("name", name, "mask", mask, "regex", regex));
    }

    private static void writeResult(List<Path> source, Path target) {
        try (PrintWriter out = new PrintWriter(new FileWriter(target.toFile(), StandardCharsets.UTF_8))) {
            for (Path path : source) {
                out.println(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
