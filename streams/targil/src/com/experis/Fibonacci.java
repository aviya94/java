package com.experis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Fibonacci {
    public ArrayList<Long> fibo(int limit) {
        long firstTerm = 0;
        long secondTerm = 1;
        ArrayList<Long> fibo = new ArrayList<Long>();
        for (int i = 0; i < limit; ++i) {
            fibo.add(firstTerm);
            long nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        return fibo;

    }

    public Stream<Long> fibonacciStream() {

        Stream<Long> stream = Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]})
                .map(t -> t[0]);
        return stream;
    }
}
