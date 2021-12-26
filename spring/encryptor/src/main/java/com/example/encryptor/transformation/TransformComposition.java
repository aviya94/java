package com.example.encryptor.transformation;

import com.example.encryptor.annotation.CharEnc;
import com.example.encryptor.annotation.WordEnc;
import com.example.encryptor.config.CompoConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransformComposition<T> {

    private List<Transform<T>> transforms=new ArrayList<>();

    public void addTransform(Transform<T> transform) {
        transforms.add(transform);
    }

    public T applyComposition(T massage) {
        for (Transform<T> transform : transforms) {
            massage = (T) transform.transform(massage);
        }
        return massage;
    }
}
