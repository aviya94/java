package com.experis;

import java.util.function.Function;
import java.util.function.Predicate;

public class Transformation {
    public Predicate<String> condition;

    public Transformation(Predicate<String> condition) {
        this.condition = condition;
    }

    public <T> T transform(Function<T, T> transform, T massege) {
        return transform.apply(massege);
    }

    public Function<String, String> caesarEncryptionTransform(String massage) {

        Function<String, String> caesarEncryption = (str) -> {
            char[] messageArray = str.toCharArray();
            for (int i = 0; i < messageArray.length; i++) {

                if (messageArray[i] < 'n' && messageArray[i] >= 'a' || messageArray[i] < 'N' && messageArray[i] >= 'A') {
                    messageArray[i] = (char) (messageArray[i] + 13);
                } else if (messageArray[i] <= 'z' && messageArray[i] >= 'n' || messageArray[i] <= 'Z' && messageArray[i] >= 'N') {
                    messageArray[i] = (char) (messageArray[i] - 13);
                }
            }
            return String.valueOf(messageArray);
        };
        return caesarEncryption;

    }

    public Function<String, String> censorTransforn(String massage) {
        Function<String, String> censor = str -> {
            String[] massgeWors = str.split(" ");

            for (int i = 0; i < massgeWors.length; i++) {
                if (condition.test(massgeWors[i])) {
                    String stars = fillStars(massgeWors.length);
                    massgeWors[i] = stars;
                }

            }
            return String.join(" ", massgeWors);
        };
        return censor;
    }

    public String fillStars(int size) {
        String stars = "*";
        for (int i = 1; i < size; i++) {
            stars = stars + "*";
        }
        return stars;
    }

    public Function<String, String> upperCaseTransforn(String massage) {
        Function<String, String> upperCase = (str) -> {
            str.toUpperCase();
            return str;
        };
        return upperCase;
    }

}
