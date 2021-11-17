package com.experis.tests;

import com.experis.anagram.SupersetAnagram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupersetAnagramTest {
    SupersetAnagram supersetAnagram;

    @BeforeEach
    void setUp() {
        ArrayList<String> words = new ArrayList<>();
        words.add("bjca");
        words.add("bcg");
        words.add("ciab");
        words.add("bbc");
        words.add("oaqceb");
        supersetAnagram = new SupersetAnagram("abc", words);
    }

    @Test
    void anagram() {
        ArrayList<String> words = new ArrayList<>();
        words.add("bjca");
        words.add("ciab");
        words.add("oaqceb");
        assertEquals(words, supersetAnagram.anagram());
    }
}