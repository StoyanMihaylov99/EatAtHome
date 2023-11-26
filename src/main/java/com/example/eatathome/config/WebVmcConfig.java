package com.example.eatathome.config;

import com.example.eatathome.utils.StringToCityEnumConverter;
import jakarta.persistence.Convert;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebVmcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToCityEnumConverter());
    }
}
