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
            StringBuilder sb = new StringBuilder(str);

            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);

                if (ch < 'n' && ch >= 'a' || ch < 'N' && ch >= 'A') {
                    sb.setCharAt(i, (char) (ch + 13));

                } else if (ch <= 'z' && ch >= 'n' || ch <= 'Z' && ch >= 'N') {
                    sb.setCharAt(i, (char) (ch - 13));
                }
            }

            return String.valueOf(sb);
        };
        return caesarEncryption;

    }

    public Function<String, String> censorTransforn(String massage) {
        Function<String, String> censor = str -> {
            String[] massegeWors = str.split(" ");

            for (int i = 0; i < massegeWors.length; i++) {
                if (condition.test(massegeWors[i])) {
                    String stars = fillStars(massegeWors.length);
                    massegeWors[i] = stars;
                }

            }
            return String.join(" ", massegeWors);
        };
        return censor;
    }

    private String fillStars(int size) {
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
