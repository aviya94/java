package com.experis.comput.operands.unary;

public class LgOperator extends UnaryOperators {

    @Override
    public double value() {
        return Math.log(left.value());
    }
}
