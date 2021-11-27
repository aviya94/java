package com.experis.test;

import com.experis.GameRunning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRunningTest {
    GameRunning gameRunning;
    @BeforeEach
    void setUp() {
        int[][] mat = new int[][]{{1, 1, 0, 1}, {1, 1, 1, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
         gameRunning=new GameRunning(mat,2);
    }

    @Test
    void game(){
        int[][] result= gameRunning.getBoard();
        int[][] excepted = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 0}};

        for (int i = 0; i < excepted.length; i++) {
            for (int j = 0; j < excepted[i].length; j++) {
                assertEquals(excepted[i][j], result[i][j]);
            }


        }
    }
}