package com.experis.operands;

import java.util.ArrayList;

public class BinaryOperators {
    ArrayList<String> operators;

    public BinaryOperators() {
        operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        operators.add("%");

    }

    public double calculation(int firstNumber, int secondNumber, String operand) {
        switch (operand) {
            case "+" -> {
                return firstNumber + secondNumber;
            }
            case "-" -> {
                return firstNumber - secondNumber;
            }
            case "*" -> {
                return firstNumber * secondNumber;
            }
            case "/" -> {
                return firstNumber / secondNumber;
            }
            case "%" -> {
                return firstNumber % secondNumber;
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }


}
