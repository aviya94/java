package com.experis;

public class FourthQuestion {
    public static int kLargestElement(int[] numbers, int start, int end, int k) {

        int partitionIndex = partition(numbers, start, end);

        if (partitionIndex == (numbers.length-k)) {
            return numbers[partitionIndex];

        } else if ((numbers.length-k)>partitionIndex) {
           return kLargestElement(numbers, partitionIndex + 1, end, k);
        }
        else {
            return kLargestElement(numbers, start, partitionIndex - 1, k);
        }

    }

    private static int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (numbers[j] <= pivot) {
                i++;
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;

            }

        }
        i++;
        int temp = numbers[i];
        numbers[i] = pivot;
        numbers[end] = temp;
        return i;

    }
}
