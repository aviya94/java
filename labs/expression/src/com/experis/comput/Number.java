package com.experis.comput;

import com.experis.comput.Computable;

public class Number implements Computable {
    private int data;

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public double value() {
        return data;
    }
}
