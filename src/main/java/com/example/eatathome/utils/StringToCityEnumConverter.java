package com.example.eatathome.utils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;

@ComponentScan
public class StringToCityEnumConverter implements Converter<String,City> {

    @Override
    public City convert(String source) {
        try {
            return City.valueOf(source.toUpperCase()); // Assuming enum values are in uppercase
        } catch (IllegalArgumentException e) {
            // Handle the case where the provided string doesn't match any enum constant
            throw new IllegalArgumentException("Invalid City: " + source);
        }
    }
}


