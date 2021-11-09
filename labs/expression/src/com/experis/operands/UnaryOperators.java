package com.experis.operands;

import java.util.ArrayList;

public class UnaryOperators {

    ArrayList<String> operators;

    public UnaryOperators() {
        operators = new ArrayList<>();
        operators.add("sqrt");
        operators.add("lg");
    }

    public double calculation(int number, String operand) {
        switch (operand) {
            case "sqrt" -> {
                return Math.sqrt(number);
            }
            case "lg" -> {
                return Math.log(number);
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

}
