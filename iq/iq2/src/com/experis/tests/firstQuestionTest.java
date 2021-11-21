package com.experis.tests;

import com.experis.FirstQuestion;

import static org.junit.jupiter.api.Assertions.*;

class firstQuestionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test

    void find() {
        int []numbers=new int[]{1,2,3,4,5,4,6,2,9,8};
        int result = FirstQuestion.find(numbers);
        int excepted=2;
        assertEquals(excepted,result);
    }
}