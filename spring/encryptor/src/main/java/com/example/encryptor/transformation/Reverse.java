package com.example.encryptor.transformation;

import com.example.encryptor.annotation.CharEnc;
import org.springframework.stereotype.Component;

@Component
@CharEnc
public class Reverse implements Transform<String> {
    @Override
    public String transform(String message) {
        StringBuilder sb = new StringBuilder(message);
        sb.reverse();
        return String.valueOf(sb);
    }
}
