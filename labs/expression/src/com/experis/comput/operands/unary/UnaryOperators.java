package com.experis.comput.operands.unary;

import com.experis.comput.Computable;

import java.util.ArrayList;

public abstract class UnaryOperators implements Computable {
    private Computable left;

    public void setLeft(Computable left) {
        this.left = left;
    }

    public Computable getLeft() {
        return left;
    }
}