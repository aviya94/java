package com.example.encryptor.transformation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public interface Transform<T> {
    String transform(T message);
}
