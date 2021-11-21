package com.experis;

import java.util.ArrayList;
import java.util.HashSet;

public class ThirdQuestion {
    public static Object[] computeKLargestNumbers(ArrayList<Integer> numbers, int k) {

        if (k > numbers.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int min = numbers.get(0);
        HashSet<Integer> kLargestNumbers = new HashSet<>();

        for (int i = 0; i < k; i++) {
            int value = numbers.get(i);

            if (min > value) {
                min = value;
            }
            kLargestNumbers.add(value);
        }

        for (int i = 0; i < numbers.size(); i++) {
            int value = numbers.get(i);

            if (value > min) {
                kLargestNumbers.remove(min);
                kLargestNumbers.add(value);
                min = kLargestNumbers.stream().min((x, y) -> Integer.compare(x, y)).get();
            }

        }
        return kLargestNumbers.stream().toArray();
    }
}
