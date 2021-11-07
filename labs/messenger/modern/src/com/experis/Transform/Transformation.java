package com.experis.Transform;

import java.util.function.Function;
import java.util.function.Predicate;

public class Transformation {
    public Predicate<String> condition;

    public Transformation(Predicate<String> condition) {
        this.condition = condition;
    }

    public <T> T transform(Function<T, T> transform, T massage) {
        return transform.apply(massage);
    }


}
