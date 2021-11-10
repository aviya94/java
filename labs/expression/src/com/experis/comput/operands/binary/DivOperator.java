package com.experis.comput.operands.binary;

public class DivOperator extends BinaryOperators{
    @Override
    public double value() {
        return left.value() / right.value();
    }
}
