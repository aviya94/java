package com.experis.tests;

import com.experis.FirstQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class FirstQuestionTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void unsortedArraySumOfTwoElements() {
        int[] v = {8, 3, 9, 7, 4, 5, 42, 2, 12, 10, 6, 24};
        int[] r = FirstQuestion.unsortedArraySumOfTwoElements(v, 21);
        int [] excepted=new int[]{9,12};

        for (int i = 0; i < excepted.length; i++) {
            assertEquals(excepted[i],r[i]);
        }
    }

}