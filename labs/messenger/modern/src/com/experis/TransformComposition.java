package com.experis;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TransformComposition<T> {
    private List<Function<T,T>> transforms;

    public TransformComposition() {
        this.transforms = transforms = new ArrayList<>();
    }

    public void addTransform(Function<T,T> transform) {
        transforms.add(transform);
    }

    public T applyComposition(T massege) {
        for (Function<T,T> transform : transforms) {
            massege = transform.apply(massege);
        }
        return massege;
    }
}
