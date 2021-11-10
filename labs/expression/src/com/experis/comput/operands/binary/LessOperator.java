package com.experis.comput.operands.binary;

import com.experis.token.Token;
import com.experis.token.TokenValue;

public class LessOperator extends BinaryOperators {
    public LessOperator() {
        TokenValue.add("-", Token.BINARY_OPERAND);
    }

    @Override
    public double value() {
        return left.value() + right.value();
    }
}
