package com.experis.tests;

import com.experis.ThirdQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ThirdQuestionTest {

    private ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        final var N = 10_000_000;
        var rng = new Random();
        list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(rng.nextInt(42_000));
        }
    }

    @Test
    void computeKLargestNumbers() {
        var result= ThirdQuestion.computeKLargestNumbers(list,1);
        assertEquals(list.stream().max((x,y)->Integer.compare(x,y)).get(),result[0] );
    }
}