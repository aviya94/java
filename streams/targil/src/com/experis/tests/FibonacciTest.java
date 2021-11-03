package com.experis.tests;

import com.experis.Fibonacci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    void fibo_sum() {
        long sumStreamFibo;
        Stream<Long> fibnacciStream = fibonacci.fibonacciStream();
        sumStreamFibo = fibnacciStream.limit(100)
                .mapToLong(integer -> integer)
                .sum();
        ArrayList<Long> fiboFunc = fibonacci.fibo(100);
        long sumFuncFibo = 0;

        for (int i = 0; i < 100; i++) {
            sumFuncFibo += fiboFunc.get(i);
        }
        assertEquals(sumFuncFibo, sumStreamFibo);

    }

    @Test
    void fibo_sum_odd() {
        long sumStreamFibo;
        Stream<Long> fibnacii = fibonacci.fibonacciStream();
        sumStreamFibo = fibnacii.filter(n -> n % 2 != 0)
                .limit(100)
                .mapToLong(integer -> integer)
                .sum();
        ArrayList<Long> fiboFunc = fibonacci.fibo(150);
        long sumFuncFibo = 0;
        for (int i = 0; i < 150; i++) {
            if (fiboFunc.get(i) % 2 != 0) {
                sumFuncFibo += fiboFunc.get(i);
            }
        }
        assertEquals(sumFuncFibo, sumStreamFibo);

    }

}