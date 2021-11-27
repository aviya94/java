package com.experis;

import java.util.*;

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

    public static int[] computeKLargestNumbers(int[] numbers, int start, int end, int k) {

        int partitionIndex = partition(numbers, start, end);

        if (partitionIndex == (numbers.length - k)) {
            return addToResult(numbers, partitionIndex, k);

        } else if ((numbers.length - k) > partitionIndex) {
            return computeKLargestNumbers(numbers, partitionIndex + 1, end, k);
        } else {
            return computeKLargestNumbers(numbers, start, partitionIndex - 1, k);
        }
    }

    private static int[] addToResult(int[] numbers, int partitionIndex, int k) {
        int[] result = new int[k];
        for (int i = partitionIndex, j = 0; i < numbers.length; i++, j++) {
            result[j] = numbers[i];

        }
        return result;
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

    public static int[] computeKLargestNumbers(int[] numbers, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(numbers.length, (x, y) -> {
            int compare = Integer.compare(y, x);
            return compare;
        });

        for (int i = 0; i < numbers.length; i++) {
            priorityQueue.add(numbers[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }


}
