package com.experis.test;

import com.experis.WriteToPPM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriteToPPMTest {

    @BeforeEach
    void setUp() {
        int[][] mat = new int[][]{{1, 1, 0, 1}, {1, 1, 1, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        WriteToPPM writeToPPM=new WriteToPPM(mat);

    }
    @Test
    void t(){

    }
}