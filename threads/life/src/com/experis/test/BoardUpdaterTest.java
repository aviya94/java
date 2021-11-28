package com.experis.test;

import com.experis.BoardUpdater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardUpdaterTest {
    private BoardUpdater boardUpdater;

    @BeforeEach
    void setUp() {
        int[][] mat = new int[][]{{1, 1, 0, 1}, {1, 1, 1, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        boardUpdater = new BoardUpdater(mat);
    }

    @Test
    void update() {

        int[][] excepted = new int[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 0}};
        boardUpdater.update(0,0,excepted.length,excepted[0].length);
        int[][] result = boardUpdater.getBoard();

        for (int i = 0; i < excepted.length; i++) {
            for (int j = 0; j < excepted[i].length; j++) {
                assertEquals(excepted[i][j], result[i][j]);
            }


        }
    }
}