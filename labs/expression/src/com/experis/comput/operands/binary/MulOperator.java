package com.experis.comput.operands.binary;

public class MulOperator extends BinaryOperators {
    @Override
    public double value() {
        return left.value() * right.value();
    }
}
