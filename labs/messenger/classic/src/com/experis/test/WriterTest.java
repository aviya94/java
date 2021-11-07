package com.experis.test;

import com.experis.destanation.FileWriterMassenger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WriterTest {
    private FileWriterMassenger fileWriterr;
    private File tempFileWrite;

    @BeforeEach
    void setUp() {
        tempFileWrite = new File("./resources/WriteTemp.txt");
        fileWriterr = new FileWriterMassenger("./resources/WriteTemp.txt");
    }

    @AfterEach
    void after() {
        tempFileWrite.delete();
    }

    @Test
    void writing_to_file() {
        String message = "hello world";
        fileWriterr.write(message);
        fileWriterr.closeWrite();
        
        try {
            FileReader fileReader = new FileReader("./resources/WriteTemp.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = bufferedReader.readLine();
            bufferedReader.close();
            assertEquals(message, result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}