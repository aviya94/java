package com.example.encryptor.transformation;

import com.example.encryptor.annotation.WordEnc;
import com.example.encryptor.config.ReplaceCertainConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@WordEnc
public class WordsCertainReplacer implements Transform<String> {
    private HashMap<String, String> dicWords;

    @Autowired
    public WordsCertainReplacer(ReplaceCertainConfigProperties dicWords) {
        this.dicWords = dicWords.getWords();
    }

    @Override
    public String transform(String message) {
        var words = message.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            var dicWord = dicWords.get(words[i]);
            if (dicWord != null) {
                words[i] = dicWord;
            }
        }
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return String.valueOf(sb);
    }
}
