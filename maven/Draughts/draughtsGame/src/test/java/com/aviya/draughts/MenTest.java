package com.aviya.draughts;

import com.aviya.draughts.soldier.MenRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MenTest {
    private MenRules men;

    @BeforeEach
    void setUp() {
        men = new MenRules();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,2,1,2",
            "2,2,3,2",
            "2,2,2,1",
            "2,2,2,3",
            "2,2,1,3",
            "2,2,1,1"})
    void moveBlackFalse(int rowFrom, int colFrom, int rowTo, int colTo) {
        var res = men.move(new Move(rowFrom, colFrom, rowTo, colTo, new LocalPlayer(Color.BLACK)), new DraughtsBoard());
        assertFalse(res);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5,1,5,2",
            "5,1,5,0",
            "5,1,6,1",
            "5,1,4,1",
            "5,1,6,2",
            "5,1,6,0"})
    void moveWhiteFalse(int rowFrom, int colFrom, int rowTo, int colTo) {
        var res = men.move(new Move(rowFrom, colFrom, rowTo, colTo, new LocalPlayer(Color.WHITE)), new DraughtsBoard());
        assertFalse(res);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,2,3,1",
            "2,2,3,3"})
    void moveTrueBlack(int rowFrom, int colFrom, int rowTo, int colTo) {
        var board =new DraughtsBoard();
        var res = men.move(new Move(rowFrom, colFrom, rowTo, colTo, new LocalPlayer(Color.BLACK)), board);
        System.out.println(board.toString());
        assertTrue(res);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5,1,4,2",
            "5,1,4,0"})
    void moveTrueWhite(int rowFrom, int colFrom, int rowTo, int colTo) {
        var res = men.move(new Move(rowFrom, colFrom, rowTo, colTo, new LocalPlayer(Color.WHITE)), new DraughtsBoard());
        assertTrue(res);
    }

}