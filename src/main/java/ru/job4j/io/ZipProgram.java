package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class ZipProgram {

    public static void main(String[] args) throws IOException {
        if (!(args.length == 3)) {
            String ln = System.lineSeparator();
            throw new IllegalArgumentException(
                    "Invalid number of arguments. Use the following arguments to start: " + ln
                            + "-d=source_directory" + ln
                            + "-e=exclude_files" + ln
                            + "-o=output_file" + ln
            );
        }
        ArgsName argsName = ArgsName.of(args);
        Path dir = Path.of(argsName.get("d"));
        if (!dir.toFile().exists() || !dir.toFile().isDirectory()) {
            throw new IllegalArgumentException("Archived directory does not exist");
        }
        String exclude = argsName.get("e");
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException("Key parameter -e does not match the file extension format.");
        }
        List<Path> source = search(dir, p -> !p.toFile().getName().endsWith(exclude));
        Path target = Path.of(argsName.get("o"));
        new Zip().packFiles(source, target);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
