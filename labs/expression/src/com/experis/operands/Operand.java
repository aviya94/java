package com.experis.operands;

import java.util.ArrayList;

public abstract class Operand {
    ArrayList<String> operators;

    public boolean isBinaryOperators(String operator) {
        for (String s : operators) {
            if (operator.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
