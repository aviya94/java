package com.experis.tests;

import com.experis.MaximalUniqueCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximalUniqueCharacterTest {
    MaximalUniqueCharacter maximalUniqueCharacter;

    @BeforeEach
    void setUp() {
        maximalUniqueCharacter = new MaximalUniqueCharacter("abbaxyzabcaacca");
    }

    @Test
    void find() {
        assertEquals("xyzabc", maximalUniqueCharacter.find());
    }
}