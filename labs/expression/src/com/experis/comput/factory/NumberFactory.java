package com.experis.comput.factory;

import com.experis.comput.Computable;
import com.experis.comput.Number;
import com.experis.token.Token;
import com.experis.token.TokenValue;
import java.util.function.Function;

public class NumberFactory implements FactoryOperand<String> {

    @Override
    public void addToTokenValue(String val) {
        Function<String, Computable> b = (a) -> this.create(a);
        TokenValue.addFactory(Token.NUMBER, b);
    }

    public NumberFactory() {
        addToTokenValue("-1");
    }

    @Override
    public Computable create(String op) {
        try {
            int result = Integer.parseInt(op);
        } catch (NumberFormatException nfe) {
            return null;
        }

        return new Number();
    }
}
