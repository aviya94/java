package com.experis;

public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    T value;

    TreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }

}
