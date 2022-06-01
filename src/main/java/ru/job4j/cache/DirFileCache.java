package ru.job4j.cache;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String rsl;
        try {
            rsl = Files.readString(Path.of(cachingDir, key), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException("Неверно указана директория или имя файла");
        }
        return rsl;
    }
}
