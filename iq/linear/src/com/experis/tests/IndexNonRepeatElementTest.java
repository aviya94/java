package com.experis.tests;

import com.experis.IndexNonRepeatElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexNonRepeatElementTest {
    IndexNonRepeatElement indexNonRepeatElement;

    @BeforeEach
    void setUp() {
        int[] numbers = new int[]{12, 7, 3, 12, 9, 7, 6, 11, 8, 15};
        indexNonRepeatElement = new IndexNonRepeatElement(numbers);
    }

    @Test
    void find() {
        assertEquals(3, indexNonRepeatElement.find());
    }
}