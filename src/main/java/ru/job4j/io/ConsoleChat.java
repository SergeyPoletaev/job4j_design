package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/bot.log", "./data/bot_answer.txt");
        cc.run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        List<String> log = new ArrayList<>();
        String word = sc.nextLine();
        log.add(word);
        while (!word.equals(OUT)) {
            if (word.equals(STOP)) {
                while (!word.equals(CONTINUE)) {
                    word = sc.nextLine();
                    log.add(word);
                }
            } else {
                List<String> listAnswers = readPhrases();
                int index = ThreadLocalRandom.current().nextInt(0, listAnswers.size());
                String answer = listAnswers.get(index);
                System.out.println(answer);
                log.add(answer);
            }
            word = sc.nextLine();
            log.add(word);
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            rsl = in.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
