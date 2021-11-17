package com.experis.anagram;

import java.util.ArrayList;
import java.util.List;

public class SupersetAnagram {
    private String word;
    private ArrayList<String> wordList;

    public SupersetAnagram(String word, ArrayList<String> wordList) {
        this.word = word;
        this.wordList = wordList;
    }

    public List<String> anagram() {
        ArrayList<String> result = wordList;
        char[] chWord = word.toCharArray();

        for (char ch : chWord) {
            removeFromResult(result, ch);
        }
        return result;
    }

    private void removeFromResult(ArrayList<String> result, char ch) {
        int index = 0;

        while (result.size() != index) {

            if (result.get(index).indexOf(ch) == -1) {
                result.remove(result.get(index));

            } else {
                index++;
            }
        }
    }

}
