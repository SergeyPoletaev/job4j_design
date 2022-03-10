package ru.job4j.io.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainGSON {

    public static void main(String[] args) {
        final Student student =
                new Student("Anna", 10, true, new Group("45-P"), new String[]{"diploma", "photo"});
        final Gson gson = new GsonBuilder().create();
        String studentToJson = gson.toJson(student);
        System.out.println("Student to Json is: " + studentToJson);
        final Student studentFromJson = gson.fromJson(studentToJson, Student.class);
        System.out.println("Student from Json is: " + studentFromJson);
    }
}
