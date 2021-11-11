package com.experis.expressoinTree;

import com.experis.Parser.TokenParser;
import com.experis.comput.Computable;
import com.experis.comput.operands.binary.BinaryOperators;
import com.experis.token.Token;
import com.experis.token.TokenValue;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Function;

import static com.experis.token.TokenValue.getToken;

public class ExpressionTree {
    private TreeNode<String, Token> root;
    private Hashtable<Token, String> prefixArrayList;

    public ExpressionTree(String prefixExpression) {
        root = new TreeNode<>(null);
        TokenParser arrayListParser = new TokenParser(" ");
        this.prefixArrayList = arrayListParser.Parser(prefixExpression);
        Hashtable<Token, String> ArrayList = arrayListParser.Parser(prefixExpression);
        createExpirationTree(ArrayList, root);
    }

    void createExpirationTree(Hashtable<Token, String> arrayPrefix, TreeNode<String, Token> node) {
        String val = arrayPrefix.get(0);
        Token token = arrayPrefix.keys().nextElement();
        arrayPrefix.remove(0);
        node.value = val;

        if (token == Token.NUMBER) {
            return;

        } else if (token == Token.BINARY_OPERAND) {
            node.setLeft(new TreeNode<>(null));
            node.setRight(new TreeNode<>(null));
            createExpirationTree(arrayPrefix, node.getLeft());
            createExpirationTree(arrayPrefix, node.getRight());

        } else if (token == Token.UNARY_OPERAND) {
            node.setLeft(new TreeNode<>(null));
            createExpirationTree(arrayPrefix, node.getLeft());
        }
    }


}
