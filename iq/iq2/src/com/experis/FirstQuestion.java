package com.experis;

import java.util.HashMap;

public class FirstQuestion {
    public static Integer find(int[] numbers) {

        Integer result = null;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            result = getInteger(numbers, result, hashMap, i);
        }

        return result;
    }

    private static Integer getInteger(int[] numbers, Integer result, HashMap<Integer, Integer> hashMap, int index) {

        if (hashMap.get(numbers[index]) == null) {
            hashMap.put(numbers[index], 1);

        } else {
            hashMap.replace(numbers[index], hashMap.get(numbers[index]) + 1);
            result = numbers[index];
        }
        return result;
    }

}
