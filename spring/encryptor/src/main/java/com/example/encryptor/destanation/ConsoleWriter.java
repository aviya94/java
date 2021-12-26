package com.example.encryptor.destanation;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements Writer<String> {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}

