package com.experis.tests;

import com.experis.FirstQuestion;
import com.experis.FourthQuestion;
import com.experis.ThirdQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourthQuestionTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void kLargestElement() {
        int []arr=new int[]{8, 9, 1, 4,5, 10};
        int start =0;
        int end =5;
        int k=2;
        int result =FourthQuestion.kLargestElement(arr,start,end,k);
        assertEquals(9,result);
    }

    @Test
    void computeKLargestNumbers() {
        int []arr=new int[]{8, 9, 1, 4,5, 10};
        int start =0;
        int end =5;
        int k=3;
        int []result =ThirdQuestion.computeKLargestNumbers(arr,start,end,k);
        int []res=new int[]{8,9,10};
        assertEquals(res,result);
    }


@Test
    void computeKLargestNumbers2() {
        int []arr=new int[]{8, 9, 1, 4,5, 10};
        int start =0;
        int end =5;
        int k=3;
        int []result =ThirdQuestion.computeKLargestNumbers(arr,k);
        int []res=new int[]{8,9,10};
        assertEquals(res,result);
    }
}