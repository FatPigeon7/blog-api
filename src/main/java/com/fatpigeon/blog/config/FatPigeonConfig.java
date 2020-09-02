package com.fatpigeon.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "fatpigeon")
public class FatPigeonConfig {
    private String foreEndUrl;
}
