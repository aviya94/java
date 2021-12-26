package com.example.encryptor.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "replacecartin")
public class ReplaceCertainConfigProperties {
    private HashMap<String,String> words=new HashMap<>();
}
