package com.example.encryptor.transformation;

import com.example.encryptor.annotation.CharEnc;
import com.example.encryptor.config.VowelConfigProperties;

import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@CharEnc
public class VowelReplacer implements Transform<String> {
    private final HashSet<Character> charList;

    public VowelReplacer(VowelConfigProperties vowelConfigProperties) {
        this.charList = vowelConfigProperties.getChars();
    }

    @Override
    public String transform(String message) {
        StringBuilder stringBuilder = new StringBuilder(message);

        for (int i = 0; i < message.length(); i++) {
            var toReplace = charList.contains(stringBuilder.charAt(i));

            if (toReplace) {
                stringBuilder.replace(i, i + 1, "*");
            }

        }
        return String.valueOf(stringBuilder);
    }
}

