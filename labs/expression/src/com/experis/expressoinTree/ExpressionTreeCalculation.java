package com.experis.expressoinTree;
import com.experis.comput.Computable;
import com.experis.comput.Number;
import com.experis.comput.operands.binary.BinaryOperators;
import com.experis.comput.operands.unary.UnaryOperators;
import com.experis.token.Token;
import com.experis.token.TokenValue;

import java.util.function.BinaryOperator;


public class ExpressionTreeCalculation {
    ExpressionTree expressionTree;

    public ExpressionTreeCalculation(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    private void createCalculateTree(TreeNode<String, Token> node) {
        if (node.Token == Token.BINARY_OPERAND) {
            createCalculateTree(node.getLeft());
            createCalculateTree(node.getRight());
        } else if (node.Token == Token.UNARY_OPERAND) {
            createCalculateTree(node.getLeft());
        } else if (node.Token == Token.NUMBER) {
            return;
        }
    }

    public void CalculateTree(TreeNode<String, Token> node, Computable computable) {
        Token token = node.Token;

        if (token == Token.NUMBER) {
            Number number = new Number();
            number.setData(Integer.valueOf(node.value));
            computable = number;
            return;

        } else if (token == Token.BINARY_OPERAND) {
            BinaryOperators binaryOperators = (BinaryOperators) TokenValue.getFactory(Token.BINARY_OPERAND).apply(node.value);
            computable = binaryOperators;
            CalculateTree(node.getLeft(), ((BinaryOperators) computable).getLeft());
            CalculateTree(node.getRight(), ((BinaryOperators) computable).getRight());

        } else if (token == Token.UNARY_OPERAND) {
            UnaryOperators unaryOperators = (UnaryOperators) TokenValue.getFactory(Token.UNARY_OPERAND).apply(node.value);
            computable = unaryOperators;
            CalculateTree(node.getLeft(), ((UnaryOperators) computable).getLeft());
        }
    }
}

