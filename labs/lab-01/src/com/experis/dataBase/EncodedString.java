package com.experis.dataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class EncodedString implements Comparable<ArrayList<Integer>> {

    public ArrayList<Integer> codeStr = new ArrayList<>();
    EncodedMap encodedMap;

    public EncodedString(String str, EncodedMap encodedMap) {
        this.encodedMap = encodedMap;
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            codeStr.add(encodedMap.get(words[i]));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int code : codeStr) {
            sb.append(encodedMap.get(code) + " ");
        }
        sb.substring(0, sb.length() - 2);
        return String.valueOf(sb);
    }

    @Override
    public int compareTo(ArrayList<Integer> o) {
        if (codeStr.size() != o.size()) {
            return -1;
        }
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i) != codeStr.get(i)) {
                return -1;
            }
        }
        return 0;
    }
}
