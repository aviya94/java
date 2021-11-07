package com.experis.sourse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderMassenger implements Reader<String> {

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    public FileReaderMassenger(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read() {
        String line = null;

        try {
            line = bufferedReader.readLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (line == null) {
            closeFile();
        }
        return line;
    }

    private void closeFile() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
