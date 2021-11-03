package com.experis.Search;

import java.util.ArrayList;

abstract class CuttingString {
    static String catString(String str, String start, String end, int stepAfterStart) {
        String wordWithoutSign = str.substring(str.indexOf(start) + stepAfterStart);
        wordWithoutSign = wordWithoutSign.substring(0, wordWithoutSign.indexOf(end));
        return wordWithoutSign;
    }


    static String[] substringToOnlyTitleWord(String choice) {
        Boolean isContain = false;
        String a[] = choice.split(" ");
        ArrayList<String> result = new ArrayList<>();

        for (String s : a) {
            if (s.contains("a:\"") || s.contains("p:\"")) {
                if (!s.endsWith("\"")) {
                    isContain = true;
                }
                continue;

            } else if (isContain == true) {
                if (s.contains("\"")) {
                    isContain = false;
                }
            } else {
                result.add(s);
            }
        }
        return result.toArray(new String[0]);
    }

}
