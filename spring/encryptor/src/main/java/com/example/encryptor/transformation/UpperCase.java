package com.example.encryptor.transformation;

import com.example.encryptor.annotation.CharEnc;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@CharEnc
public class UpperCase implements Transform<String> {
    @Override
    public String transform(String message) {
        return message.toUpperCase();
    }
}
