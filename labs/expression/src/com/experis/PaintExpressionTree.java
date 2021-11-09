package com.experis;


public class PaintExpressionTree {
    public PaintExpressionTree(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    ExpressionTree expressionTree;

    public void paint(TreeNode node) {

        if (node == null) {
            return;
        }

        paint(node.left);

        System.out.printf("%s ", node.value);
        paint(node.right);


    }
}
