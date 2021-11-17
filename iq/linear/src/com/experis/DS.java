package com.experis;

import java.util.ArrayList;

public class DS {
    private int size;
    private Integer[] numbers;
    private Boolean reset = false;
    private int resetValue;

    public DS(int size) {
        this.size = size;
        this.numbers = new Integer[size];
    }

    public int get(int index) {
        if (reset == true) {
            if (numbers[index] != null) {
                return numbers[index];
            }
            return resetValue;
        }
        return numbers[index];
    }

    public void set(int index, int value) {
        numbers[index] = value;
    }

    public void reset(int value) {
        numbers = new Integer[size];
        resetValue = value;
        reset = true;
    }
}
