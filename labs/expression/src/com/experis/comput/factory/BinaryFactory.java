package com.experis.comput.factory;

import com.experis.comput.Computable;
import com.experis.comput.operands.binary.BinaryOperators;
import com.experis.token.Token;
import com.experis.token.TokenValue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BinaryFactory {
    private HashMap<String, BinaryOperators> binaryOperators;

    public BinaryFactory(HashMap<String, BinaryOperators> binaryOperators) {
        this.binaryOperators = binaryOperators;
        addToTokenValue();
    }

    public BinaryOperators create(String operator) {
        BinaryOperators val = binaryOperators.get(operator);
        if (val == null) {
            throw new IllegalArgumentException();
        }
        return val;
    }

    public void addToTokenValue() {
        Function<String, Computable> b = (a) -> this.create(a);
        TokenValue.addFactory(Token.BINARY_OPERAND, b);

        for (Map.Entry<String, BinaryOperators> entry : binaryOperators.entrySet()) {
            TokenValue.add(entry.getKey(), Token.BINARY_OPERAND);
        }
    }
}
