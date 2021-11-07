package com.experis.Transformation;

import java.util.ArrayList;
import java.util.List;

public class TransformComposition<T> {
    private List<Transform<T>> transforms;

    public TransformComposition() {
        this.transforms = transforms = new ArrayList<>();
    }

    public void addTransform(Transform<T> transform) {
        transforms.add(transform);
    }

    public T applyComposition(T massege) {
        for (Transform<T> transform : transforms) {
            massege = (T) transform.transforn(massege);
        }
        return massege;
    }
}
