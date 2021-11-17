package com.experis.tests;

import com.experis.anagram.SubstringAnagram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubstringAnagramTest {

    private SubstringAnagram substringAnagram;

    @BeforeEach
    void setUp() {
        ArrayList<String> words = new ArrayList<>();
        words.add("bcaa");
        words.add("bcg");
        words.add("acabd");
        words.add("bbc");
        words.add("abacb");
        substringAnagram = new SubstringAnagram("abc", words);
    }

    @Test
    void anagram() {
        ArrayList<String> words = new ArrayList<>();
        words.add("bcaa");
        words.add("acabd");
        words.add("abacb");
        assertEquals(words, substringAnagram.anagram());
    }
}