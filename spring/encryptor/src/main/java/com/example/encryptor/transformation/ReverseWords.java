package com.example.encryptor.transformation;

import com.example.encryptor.annotation.WordEnc;
import org.springframework.stereotype.Component;

@Component
@WordEnc
public class ReverseWords implements Transform<String> {
    @Override
    public String transform(String message) {
        var words = message.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);

            if (i != 0) {
                sb.append(" ");
            }
        }
        return String.valueOf(sb);
    }
}
