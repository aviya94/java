package com.experis.comput;

import com.experis.comput.Computable;

public class Number implements Computable {
    int data;

    @Override
    public double value() {
        return data;
    }
}
