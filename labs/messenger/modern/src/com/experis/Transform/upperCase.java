package com.experis.Transform;

import java.util.function.Function;

public class upperCase {
    public Function<String, String> upperCaseTransform(String massage) {
        Function<String, String> upperCase = (str) -> {
            str.toUpperCase();
            return str;
        };
        return upperCase;
    }

}
