package com.experis;

public class IndexNonRepeatElement {
    private int[] numbers;

    public IndexNonRepeatElement(int[] numbers) {
        this.numbers = numbers;
    }

    public Object find() {

        int[] countersArray = new int[getMax() + 1];
        for (int i = 0; i < numbers.length; i++) {
            countersArray[numbers[i]]++;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (countersArray[numbers[i]] == 1) {
                return numbers[i];
            }
        }
        return null;
    }

    private int getMax() {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }

        }
        return max;
    }
}
