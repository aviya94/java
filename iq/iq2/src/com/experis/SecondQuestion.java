package com.experis;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SecondQuestion {

    public static int find(String s, String t, String w) {

        String sortedS = sorted(s);
        String sortedT = sorted(t);
        String sortedW = sorted(w);

        HashSet<Character> result = new HashSet<>();
        int min = Integer.min(sortedS.length(), sortedT.length());
        int indexS = 0;
        int indexT = 0;

        while (indexS < min & indexT < min) {

            char chS = sortedS.charAt(indexS);
            char chT = sortedT.charAt(indexT);

            if (chS == chT) {
                result.add(chS);
                indexS++;
                indexT++;

            } else {
                indexT = getIndex(indexT, chS, chT,sortedT);
                indexS = getIndex(indexS, chT, chS,sortedS);
            }

        }
        removeFromResult(sortedW, result);

        return result.size();
    }

    private static void removeFromResult(String sortedW, HashSet<Character> result) {

        for (int i = 0; i < sortedW.length(); i++) {
            char chW = sortedW.charAt(i);

            if (result.contains(chW)) {
                result.remove(chW);
            }

        }
    }

    private static int getIndex(int index, char firstChar, char secondChar,String sortedString) {

        while (firstChar > secondChar) {
            secondChar = sortedString.charAt(++index);
        }
        return index;
    }

    private static String sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
