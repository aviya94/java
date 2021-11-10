package com.experis.expressoinTree;


public class PaintExpressionTree {
    public PaintExpressionTree(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    ExpressionTree expressionTree;

    public void paint(TreeNode node) {

        if (node == null) {
            return;
        }

        paint(node.getLeft());

        System.out.printf("%s ", node.value);
        paint(node.getRight());


    }
}
