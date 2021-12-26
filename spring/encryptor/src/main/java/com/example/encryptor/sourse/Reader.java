package com.example.encryptor.sourse;

import org.springframework.stereotype.Component;

@Component
public interface Reader <T>{
    public T read();
}
