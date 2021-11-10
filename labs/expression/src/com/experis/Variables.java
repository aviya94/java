package com.experis;

import java.util.Hashtable;

public class Variables {

    Hashtable<String, Integer> variables;

    public Variables() {
        variables = new Hashtable<>();
    }

    public int getNumber(String var) {
        Integer number = variables.get(var);
        if (number == null) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public void addVariable(String var, int number) {
        variables.put(var, number);
    }

    public Boolean isVariables(String var) {
        if (variables.get(var) != null) {
            return true;
        } else return false;
    }
}
