package com.experis.anagram;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    private String word;

    public Anagram(String word, ArrayList<String> wordList) {
        this.word = word;
        this.wordList = wordList;
    }

    private ArrayList<String> wordList;


    public List<String> anagram() {
        ArrayList<String> result = new ArrayList<>();
        int sumAsciiWord = sumAsciiChar(word);

        for (String w : wordList) {

            if (sumAsciiChar(w) == sumAsciiWord) {
                result.add(w);
            }
        }
        return result;
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
