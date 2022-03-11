package ru.job4j.io.serialization.json;

import org.json.JSONObject;

public class MainORGJSON {

    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonStudent =
                new JSONObject("{"
                        + "\"name\":\"Anna\","
                        + "\"age\":10,"
                        + "\"status\":true,"
                        + "\"group\":{\"name\":\"45-P\"},"
                        + "\"documents\":[\"diploma\",\"photo\"]"
                        + "}"
                );
        System.out.println("JSONObject из json-строки строки: " + jsonStudent);

        /* JSONObject напрямую методом put */
        final Student student =
                new Student("Anna", 15, false, new Group("15-P"), new String[]{"diploma", "photo"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", student.getName());
        jsonObject.put("age", student.getAge());
        jsonObject.put("status", student.isStatus());
        jsonObject.put("group", student.getGroup().getName());
        jsonObject.put("documents", student.getDocuments());
        System.out.println("JSONObject напрямую методом put: " + jsonObject);

        /* Преобразуем объект student в json-строку */
        System.out.println("Преобразуем объект student в json-строку: " + new JSONObject(student));
    }
}
