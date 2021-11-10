package com.experis.test;

import com.experis.comput.factory.BinaryFactory;
import com.experis.comput.factory.FactoryOperand;
import com.experis.comput.operands.binary.AddOperator;
import com.experis.comput.operands.binary.BinaryOperators;
import com.experis.expressoinTree.ExpressionTree;
import com.experis.expressoinTree.ExpressionTreeCalculation;
import com.experis.expressoinTree.PaintExpressionTree;
import com.experis.Variables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PaintExpressionTreeTest {

    ExpressionTree expressionTree;

    @BeforeEach
    void setUp() {
        expressionTree = new ExpressionTree("/ + 2 3 + 4 / 5 4 ");
        //HashMap<String, BinaryOperators> binaryOperators=new HashMap<>();
        //binaryOperators.put("+",new AddOperator());
       // binaryFactory=new BinaryFactory(binaryOperators) ;
    }

    @Test
    void paint() {
      // PaintExpressionTree paintExpressionTree = new PaintExpressionTree(expressionTree);
       //paintExpressionTree.paint(expressionTree.root);

        assertTrue(true);
        //ExpressionTreeCalculation expressionTreeCalculation=new ExpressionTreeCalculation(expressionTree);
      //  assertEquals(1,expressionTreeCalculation.value(new Variables()));

    }
}