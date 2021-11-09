package com.experis.test;

import com.experis.ExpressionTree;
import com.experis.PaintExpressionTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaintExpressionTreeTest {

    ExpressionTree expressionTree;

    @BeforeEach
    void setUp() {
        expressionTree = new ExpressionTree("/ + 2 3 + 4 / 5 4 ");
    }

    @Test
    void paint() {
        PaintExpressionTree paintExpressionTree = new PaintExpressionTree(expressionTree);
        paintExpressionTree.paint(expressionTree.head);
        assertTrue(true);

    }
}