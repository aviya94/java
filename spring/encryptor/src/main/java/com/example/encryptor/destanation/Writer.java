package com.example.encryptor.destanation;


import org.springframework.stereotype.Component;

@Component
public interface Writer <T>{
    public void write(T message);
}
