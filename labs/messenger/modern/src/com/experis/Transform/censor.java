package com.experis.Transform;

import java.util.function.Function;
import java.util.function.Predicate;

public class censor {
    public Predicate<String> condition;

    public censor(Predicate<String> condition) {
        this.condition = condition;
    }

    public Function<String, String> censorTransform(String massage) {
        Function<String, String> censor = str -> {
            String[] massageWorse = str.split(" ");

            for (int i = 0; i < massageWorse.length; i++) {
                if (condition.test(massageWorse[i])) {
                    String stars = fillStars(massageWorse.length);
                    massageWorse[i] = stars;
                }

            }
            return String.join(" ", massageWorse);
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
}
