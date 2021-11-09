package com.experis;

import com.experis.Parser.ArrayListParser;
import com.experis.operands.BinaryOperators;
import com.experis.operands.UnaryOperators;

import javax.naming.NamingEnumeration;
import java.util.ArrayList;

public class ExpressionTree {
    public TreeNode<String> head;
    ArrayList<String> prefixArrayList;
    BinaryOperators binaryOperators;
    UnaryOperators unaryOperators;

    public ExpressionTree(String prefixExpression) {
        binaryOperators=new BinaryOperators();
        unaryOperators= new UnaryOperators();
        head = new TreeNode<>(null);
        ArrayListParser arrayListParser = new ArrayListParser(" ");
        this.prefixArrayList = arrayListParser.Parser(prefixExpression);
        ArrayList<String> ArrayList=arrayListParser.Parser(prefixExpression);
        createExpirationTree(ArrayList, head);
    }

    void createExpirationTree(ArrayList<String> arrayPrefix, TreeNode<String> node) {
        String val = arrayPrefix.get(0);
        arrayPrefix.remove(0);
        node.value = val;

        if (isNumber(val)) {
            return;
        }
        node.left = new TreeNode<>(null);
        node.right = new TreeNode<>(null);
        createExpirationTree(arrayPrefix, node.left);
        createExpirationTree(arrayPrefix, node.right);
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
