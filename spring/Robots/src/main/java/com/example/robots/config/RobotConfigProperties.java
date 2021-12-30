package com.example.robots.config;


import com.example.robots.model.Model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "robot")
public class RobotConfigProperties {
    private String name;
    private String callSign;
    private String model;
}
