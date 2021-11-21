package com.experis.tests;

import com.experis.SecondQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondQuestionTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void find() {
        int result =SecondQuestion.find("ABACD", "DCRBD", "AEDGF");
        int excepted=2;
        assertEquals(excepted,result);
    }
}