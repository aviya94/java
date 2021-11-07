package com.experis.test;

import com.experis.Messanger;
import com.experis.Transformation.TransformComposition;
import com.experis.destanation.FileWriterMassenger;
import com.experis.sourse.FileReaderMassenger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessangerTest {
    private FileReaderMassenger fileReaders;
    private FileWriterMassenger fileWriting;
    private TransformComposition<String> composition;
    private File tempFileWrite;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private Messanger messanger;

    @BeforeEach
    void setUp() {

        messanger = new Messanger();
        fileReaders = new FileReaderMassenger("./resources/Read.txt");
        composition = new TransformComposition<>();
        tempFileWrite = new File("./resources/WriteTemp.txt");
        fileWriting = new FileWriterMassenger("./resources/WriteTemp.txt");

        try {

            fileReader = new FileReader("./resources/WriteTemp.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void after() {

        try {
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tempFileWrite.delete();
    }

    @Test
    void messanger() {

        messanger.sendMessage(fileReaders, composition, fileWriting);
        bufferedReader = new BufferedReader(fileReader);
        String result = "Hello World!";

        try {
            String res = bufferedReader.readLine();
            assertEquals(result, res);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



