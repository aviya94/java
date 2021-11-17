package com.experis.tests;

import com.experis.anagram.Anagram;
import com.experis.anagram.MultiAnagram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MultiAnagramTest {
MultiAnagram multiAnagram;
    @BeforeEach
    void setUp() {
        ArrayList<String> worlds=new ArrayList<>();
        worlds.add("pool");
        worlds.add("why");
        worlds.add("polo");
        worlds.add("mom");
        worlds.add("yhw");
        worlds.add("loop");
        worlds.add("top");
        multiAnagram=new MultiAnagram(worlds);
    }

    @Test
    void find() {

        ArrayList<String> a=new ArrayList<>();
        a.add("pool");
        a.add("polo");
        a.add("loop");
        ArrayList<String> b=new ArrayList<>();
        b.add("why");
        b.add("yhw");
        ArrayList<ArrayList<String>> excepted=new ArrayList<>();
        excepted.add(a);
        excepted.add(b);
        assertEquals(excepted,multiAnagram.find());


    }
}