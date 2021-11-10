package com.experis.comput.operands.unary;

public class SqrtOperator extends UnaryOperators {
    @Override
    public double value() {
        return Math.sqrt(left.value());
    }
}
