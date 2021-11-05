package com.experis.test;

import com.experis.destanation.FileWriterr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WritingTest {
    FileWriterr fileWriting;

    @BeforeEach
    void setUp() {
        fileWriting = new FileWriterr("C:\\Users\\user\\course\\java\\labs\\messenger\\classic\\src\\com\\experis\\resources\\Writh.txt");
    }

    @Test
    void writing_to_file() {
        String message="hellow word";
        fileWriting.writh("message");

    }
}