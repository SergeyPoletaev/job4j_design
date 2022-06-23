package ru.job4j.srp.adapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.job4j.srp.formatter.DateFormatter;

import java.lang.reflect.Type;
import java.util.Calendar;

public class CalendarAdapterJson implements JsonSerializer<Calendar> {
    private final DateFormatter formatter;

    public CalendarAdapterJson(DateFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(formatter.format(calendar.getTime()));
    }
}
