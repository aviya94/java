package com.example.encryptor.transformation;

import com.example.encryptor.annotation.CharEnc;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@CharEnc
public class LowerCase implements Transform<String> {
    @Override
    public String transform(String message) {
        return message.toLowerCase();
    }
}
