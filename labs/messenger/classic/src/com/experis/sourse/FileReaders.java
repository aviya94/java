package com.experis.sourse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class FileReaders implements Reader<String> {
    String filePath;

    public FileReaders(String filePath) {
        this.filePath = filePath;
    }

    public  String read() {

        try (java.io.FileReader fileReader = new java.io.FileReader(filePath)) {
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            return bufferedReader.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;


        }
    }
}
