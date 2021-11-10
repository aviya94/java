package com.experis.expressoinTree;

import com.experis.comput.operands.binary.BinaryOperators;

public class TreeNode<T,U> {
    private TreeNode<T,U> left;
    private TreeNode<T,U> right;
    T value;
    U Token;

    TreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    public void setLeft(TreeNode<T,U> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T,U> right) {
        this.right = right;
    }

    public final TreeNode<T,U> getLeft() {
        return left;
    }

    public final TreeNode<T,U> getRight() {
        return right;
    }

    public final T getValue() {
        return value;
    }
}
