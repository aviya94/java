package com.experis;

import java.util.Random;

public class InitializeGame {
    private int[][] matrix = new int[1800][1200];

    public int[][] initialization(double lifeCellPercent) {

        if (lifeCellPercent < 0 || lifeCellPercent > 1) {
            throw new IllegalArgumentException();
        }

        int lifeCell = (int) (1800 * 1200 * lifeCellPercent);

        for (int i = 0; i < lifeCell; i++) {

            Random random = new Random();
            int row = random.nextInt(1800);
            int col = random.nextInt(1200);
            matrix[row][col] = 1;
        }
        return matrix;
    }
}
