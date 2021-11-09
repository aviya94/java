package com.experis.Parser;

import java.util.ArrayList;

public class ArrayListParser implements Parser<ArrayList<String>> {
    String buffer;
    public ArrayListParser(String buffer) {
        this.buffer = buffer;
    }
    @Override
    public ArrayList<String> Parser(String val) {
        String[] arrayPrefix = val.split(buffer);
        return  convertToArrayList(arrayPrefix);

    }

    ArrayList<String> convertToArrayList(String[] arrayPrefix) {
        ArrayList<String> newArrayPrefix = new ArrayList<>();
        for (String s : arrayPrefix) {
            newArrayPrefix.add(s);
        }
        return newArrayPrefix;
    }

}
