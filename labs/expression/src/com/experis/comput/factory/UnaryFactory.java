package com.experis.comput.factory;

import com.experis.comput.Computable;
import com.experis.comput.operands.unary.UnaryOperators;
import com.experis.token.Token;
import com.experis.token.TokenValue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UnaryFactory implements FactoryOperand<HashMap<String, UnaryOperators>> {
    private HashMap<String, UnaryOperators> unaryOperators;

    public UnaryFactory(HashMap<String, UnaryOperators> unaryOperators) {
        this.unaryOperators = unaryOperators;
        addToTokenValue(unaryOperators);
    }

    public UnaryOperators create(String operator) {
        UnaryOperators val = unaryOperators.get(operator);
        if (val == null) {
            throw new IllegalArgumentException();
        }
        return val;
    }

    public void addToTokenValue(HashMap<String, UnaryOperators> Operators) {
        Function<String, Computable> b = (a) -> this.create(a);
        TokenValue.addFactory(Token.UNARY_OPERAND, b);

        for (Map.Entry<String, UnaryOperators> entry : Operators.entrySet()) {
            TokenValue.add(entry.getKey(), Token.UNARY_OPERAND);
        }
    }
}
