package com.experis;

public class MaximalUniqueCharacter {
    String testString;

    public MaximalUniqueCharacter(String testString) {
        this.testString = testString;
    }

    public String find() {
        String max = testString.substring(0, 1);
        int startIndex = 0;
        String subTestString = String.valueOf(testString.charAt(0));

        for (int i = 1; i < testString.length(); i++) {

            startIndex = getStartIndex(startIndex, subTestString, i);
            subTestString = testString.substring(startIndex, i + 1);
            max = updateMax(max, subTestString);
        }

        return max;
    }

    private String updateMax(String max, String subTestString) {
        if (subTestString.length() > max.length()) {
            max = subTestString;
        }
        return max;
    }

    private int getStartIndex(int indexStart, String subTestString, int indexEnd) {
        char charIndexEnd = testString.charAt(indexEnd);

        while (subTestString.indexOf(charIndexEnd) >= 0) {
            subTestString = testString.substring(++indexStart, indexEnd);
        }
        return indexStart;
    }
}










