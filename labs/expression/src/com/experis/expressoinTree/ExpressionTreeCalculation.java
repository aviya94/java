package com.experis.expressoinTree;


import com.experis.token.Token;
import com.experis.token.TokenValue;


public class ExpressionTreeCalculation {
    ExpressionTree expressionTree;

    public ExpressionTreeCalculation(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    private void createCalculateTree(TreeNode<String, Token> node) {
        if (node.Token == Token.BINARY_OPERAND) {
            createCalculateTree(node.getLeft());
            createCalculateTree(node.getRight());
        }
        else if(node.Token==Token.UNARY_OPERAND){
            createCalculateTree(node.getLeft());
        }
        else if(node.Token==Token.NUMBER){
            return;
        }
    }

    public Double Calculate(TreeNode<String, Token> node) {
        //sum += TokenValue.getFactory(TokenValue.getToken(node.value)).apply(node.value).value();
        return 0.0;
    }
}
