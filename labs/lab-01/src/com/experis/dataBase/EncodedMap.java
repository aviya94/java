package com.experis.dataBase;

import java.util.HashMap;

public class EncodedMap {
    public final HashMap<String, Integer> value = new HashMap<String, Integer>();
    public final HashMap<Integer, String> code = new HashMap<Integer, String>();
    private int indexInMap = 0;

    int get(String obj) {
        if (value.get(obj) == null) {
            value.put(obj, indexInMap);
            code.put(indexInMap, obj);
            return indexInMap++;
        } else {
            return value.get(obj);
        }
    }

    String get(int index) {
        return code.get(index);
    }

    public int getIndex(String index) {
        if (value.get(index) == null) {
            return -1;
        }
        return value.get(index);
    }
}
