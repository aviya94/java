package com.experis;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("AddToDoublyLinkedListTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MaxStackTest {
    private MaxStack maxStack;
    private Comparator<Integer> compere;

    @BeforeEach
    void setup() {
        compere = (a, b) -> {
            if (a < b) {
                return -1;
            } else if (b == a) {
                return 0;
            }
            else return b;

        };
        maxStack = new MaxStack<Integer>(compere);
    }

    @Test
    @Order(1)
    void push_and_pop_max_stack_integer_size_zero() {
        for (int i = 0; i < 10; i++) {
            maxStack.pushToStack(i);
        }
        for (int i = 9; i >= 0; i--) {
            maxStack.popFromStack();
        }
        assertTrue(maxStack.stack.empty());

    }

    @Test
    @Order(2)
    void push_max_stack_integer() {
        for (int i = 0; i < 10; i++) {
            maxStack.pushToStack(i);
        }

        assertTrue(maxStack.stack.size()==10);
        assertTrue((int)maxStack.maxStack==9);
        

    }


}
