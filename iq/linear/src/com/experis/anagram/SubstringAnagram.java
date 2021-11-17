package com.experis.anagram;

import java.util.ArrayList;
import java.util.List;

public class SubstringAnagram {

    private String word;

    public SubstringAnagram(String word, ArrayList<String> wordList) {
        this.word = word;
        this.wordList = wordList;
    }

    private ArrayList<String> wordList;

    public List<String> anagram() {
        ArrayList<String> result = new ArrayList<>();
        int sumAsciiWord = sumAsciiChar(word);

        for (String w : wordList) {
            String subWord = w;
            addAnagram(result, sumAsciiWord, w, subWord);
        }
        return result;
    }

    private void addAnagram(ArrayList<String> result, int sumAsciiWord, String w, String subWord) {
        for (int i = 0; i < w.length() - 3; i++) {

            subWord = w.substring(i, word.length() + i);

            if (sumAsciiChar(subWord) == sumAsciiWord) {
                result.add(w);
                break;
            }
        }
    }

    private int sumAsciiChar(String word) {
        char[] chWord = word.toCharArray();
        int sum = 0;
        for (char ch : chWord) {
            sum += ch;
        }
        return sum;
    }
}
