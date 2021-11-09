package com.experis;

import java.util.ArrayList;

public class ExpressionTreeCalculation {
    ExpressionTree expressionTree;

    public ExpressionTreeCalculation(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    public Double value(Variables variables) {
        ArrayList<String> operatorCalc = new ArrayList<>();
        double sum = 0;
        for (int i = expressionTree.prefixArrayList.size() - 1; i >= 0; i--) {
            String indexValue = expressionTree.prefixArrayList.get(i);
            addToCalculateArray(variables, operatorCalc, indexValue);
            if (expressionTree.isNumber(indexValue) == false) {
                sum = calculateOperand(operatorCalc, sum);
                operatorCalc = new ArrayList<>();
            }
        }
        return sum;
    }

    private void addToCalculateArray(Variables variables, ArrayList<String> operatorCalc, String indexValue) {

        if (variables.isVariables(indexValue)) {
            String variablesValue = String.valueOf(variables.getNumber(indexValue));
            operatorCalc.add(variablesValue);

        } else {
            operatorCalc.add(indexValue);
        }
    }

    private double calculateOperand(ArrayList<String> operatorCalc, double sum) {
        if (operatorCalc.size() == 3)
            sum += expressionTree.binaryOperators.calculation
                    (Integer.parseInt(operatorCalc.get(0)), Integer.parseInt(operatorCalc.get(1)),
                            operatorCalc.get(2));

        else if (operatorCalc.size() == 2) {
            sum += expressionTree.unaryOperators.calculation(Integer.parseInt(operatorCalc.get(0)), operatorCalc.get(1));
        }
        return sum;
    }

}
