package com.example.eatathome.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class CurrentLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {

        if (value == null) {
            gen.writeNull();
        } else {
            gen.writeString(formatter.format(value));
        }
    }

    public static String getCurrentTimestamp() {
        return formatter.format(LocalDateTime.now());
    }
}
