package com.experis.comput.operands.binary;

import com.experis.comput.Computable;

public abstract class BinaryOperators implements Computable {
    protected Computable left;
    protected Computable right;

    public Computable getLeft() {
        return left;
    }

    public void setLeft(Computable left) {
        this.left = left;
    }

    public Computable getRight() {
        return right;
    }

    public void setRight(Computable right) {
        this.right = right;
    }
}
