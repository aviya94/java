package com.experis.expressoinTree;

import com.experis.Parser.TokenParser;
import com.experis.token.Token;

import java.util.Hashtable;
import java.util.Map;

public class ExpressionTree {
    public TreeNode<String,Token> root;
    Hashtable<Token, String> prefixArrayList;

    public ExpressionTree(String prefixExpression) {
        root = new TreeNode<>(null);
        TokenParser arrayListParser = new TokenParser(" ");
        this.prefixArrayList = arrayListParser.Parser(prefixExpression);
        Hashtable<Token, String> ArrayList=arrayListParser.Parser(prefixExpression);
        createExpirationTree(ArrayList, root);
    }

    void createExpirationTree(Hashtable<Token, String> arrayPrefix, TreeNode<String,Token> node) {
        String val = arrayPrefix.get(0);
        Token token=arrayPrefix.keys().nextElement();
        arrayPrefix.remove(0);
        node.value = val;

        if (isNumber(val)) {
            return;
        }
        node.setLeft(new TreeNode<>(null));
        node.setRight(new TreeNode<>(null));
        createExpirationTree(arrayPrefix, node.getLeft());
        createExpirationTree(arrayPrefix, node.getRight());
    }

    public boolean isNumber(String val) {
        try {
            int result = Integer.parseInt(val);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
