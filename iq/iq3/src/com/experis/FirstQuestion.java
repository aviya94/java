package com.experis;

import java.util.HashMap;
import java.util.HashSet;

public class FirstQuestion {

    public static int[] unsortedArraySumOfTwoElements(int[] numbers, int sum) {
        HashMap<Integer, Integer> numbersMap = new HashMap<>();

        addToMap(numbers, numbersMap);
        return findElements(numbers, sum, numbersMap);
    }

    private static int[] findElements(int[] numbers, int sum, HashMap<Integer, Integer> numbersMap) {
        for (int number : numbers) {
            int rest = sum - number;

            if (rest == number) {

                if (numbersMap.get(rest) == 1) {
                    return null;
                }
            }

            if (numbersMap.get(rest) != null) {
                return new int[]{number, rest};
            }
        }
        return null;
    }

    private static void addToMap(int[] numbers, HashMap<Integer, Integer> numbersMap) {
        for (int number : numbers) {

            if (numbersMap.get(number) != null) {
                numbersMap.replace(number, numbersMap.get(number) + 1);

            } else {
                numbersMap.put(number, 1);
            }
        }
    }
}
