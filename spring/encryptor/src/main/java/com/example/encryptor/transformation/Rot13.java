package com.example.encryptor.transformation;

import com.example.encryptor.annotation.CharEnc;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@CharEnc
public class Rot13 implements Transform<String> {
    @Override
    public String transform(String message) {

        StringBuilder sb = new StringBuilder(message);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch < 'n' && ch >= 'a' || ch < 'N' && ch >= 'A') {
                sb.setCharAt(i, (char) (ch + 13));

            } else if (ch <= 'z' && ch >= 'n' || ch <= 'Z' && ch >= 'N') {
                sb.setCharAt(i, (char) (ch - 13));
            }
        }

        return String.valueOf(sb);
    }
}
