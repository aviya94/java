package com.aviya.draughts;

import com.aviya.draughts.soldier.MenRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {
    private MenRules men;

    @BeforeEach
    void setUp() {
        men = new MenRules();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,0,2,5",
            "4,3,5,9",
            "0,0,1,1"},
            nullValues = {"null"})
    void basicRuleFalse(int rowFrom, int colFrom, int rowTo, int colTo) {
        var result = men.basicRule(new Move(rowFrom, colFrom, rowTo, colTo, new LocalPlayer(Color.BLACK)), new DraughtsBoard());
        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,0,4,1",
            "3,6,4,5"},
            nullValues = {"null"})
    void basicRuleTrue(int rowFrom, int colFrom, int rowTo, int colTo) {
        var result = men.basicRule(new Move(rowFrom, colFrom, rowTo, colTo, new LocalPlayer(Color.BLACK)), new DraughtsBoard());
        assertTrue(result);
    }
}