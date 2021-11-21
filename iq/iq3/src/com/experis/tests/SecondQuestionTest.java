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
    void trim() {
        String str="      hello   world !   from     Java    ";
       String result= SecondQuestion.trim(str.toCharArray());
        String excepted=" hello world ! from Java ";
        assertEquals(excepted,result);
    }
}