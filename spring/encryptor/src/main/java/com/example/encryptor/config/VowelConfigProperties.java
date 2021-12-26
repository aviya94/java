package com.example.encryptor.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "vowel")
public class VowelConfigProperties {
    private HashSet<Character> chars;
}
