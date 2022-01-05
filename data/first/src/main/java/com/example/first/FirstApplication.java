package com.example.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }
@Autowired
UI ui;
    @Override
    public void run(String... args) throws Exception {

ui.run();
    }
}
