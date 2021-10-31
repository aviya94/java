package com.experis;

import java.util.Comparator;
import java.util.Stack;
import java.util.function.Function;

public class MaxStack<T> {

    Stack<T> stack = new Stack<T>();
     T maxStack;
    private Comparator<T> compere;

    public MaxStack(Comparator<T> compere) {
        this.compere = compere;
    }

    public void pushToStack(T objectToPush) {
        stack.push(objectToPush);
        updateMaxStackApterPush(objectToPush);
    }

    private void updateMaxStackApterPush(T objectToPush) {

        if (stack.empty()) {
            maxStack = objectToPush;

            if (compere.compare(maxStack, objectToPush) == -1) ;
            {
                maxStack = objectToPush;
            }
        }
    }

    public T popFromStack() {

        if (stack.empty()) {
            throw new NullPointerException("you cant pop from an empty stack");
        }

        T popNumber = stack.pop();

        if (popNumber == maxStack) {
            RemoveFromMaxStack(popNumber);
        }
        return popNumber;
    }

    private void RemoveFromMaxStack(T popObject) {

        if (stack.empty()) {
            maxStack = null;
        } else {
            T max = stack.peek();
            for (T e : stack) {
                if (compere.compare(max, e) == -1) ;
                {
                    maxStack = e;
                }
            }
        }
    }

}



