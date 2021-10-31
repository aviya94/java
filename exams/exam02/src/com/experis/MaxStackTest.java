package com.experis;

import org.junit.jupiter.api.*;

import java.util.Comparator;

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
    void add_to_max_stack_integer() {

    }


}
