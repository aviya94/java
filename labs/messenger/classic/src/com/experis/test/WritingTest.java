package com.experis.test;

import com.experis.destanation.FileWriting;
import com.experis.destanation.Writing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritingTest {
    FileWriting fileWriting;

    @BeforeEach
    void setUp() {
        fileWriting = new FileWriting("C:\\Users\\user\\course\\java\\labs\\messenger\\classic\\src\\com\\experis\\resources\\Writh.txt");
    }

    @Test
    void writing_to_file() {
        String message="hellow word";
        fileWriting.writh("message");

    }
}