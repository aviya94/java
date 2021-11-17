package com.experis.tests;

import com.experis.anagram.Anagram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
private Anagram anagram;
    @BeforeEach
    void setUp() {
        ArrayList<String> words = new ArrayList<>();
        words.add("bca");
        words.add("bcg");
        words.add("cab");
        words.add("bbc");
        words.add("acb");
        anagram = new Anagram("abc", words);
    }

    @Test
    void anagram() {
        ArrayList<String> words=new ArrayList<>();
        words.add("bca");
        words.add("cab");
        words.add("acb");
        assertEquals(words,anagram.anagram());
    }
}