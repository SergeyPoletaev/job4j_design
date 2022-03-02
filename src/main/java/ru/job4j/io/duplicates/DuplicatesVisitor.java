package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().isFile()) {
            FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
            List<Path> paths = new ArrayList<>(List.of(file.toAbsolutePath()));
            map.merge(fileProperty, paths, (vOld, vNew) -> {
                vOld.addAll(vNew);
                return vOld;
            });
        }
        return super.visitFile(file, attrs);
    }

    public void printDuplicate() {
        map.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .flatMap(e -> e.getValue().stream())
                .forEach(System.out::println);

    }
}