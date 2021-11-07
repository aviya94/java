package com.experis.sourse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Supplier;


public class FileReaderMessenger {
    String filePath;
    BufferedReader bufferedReader;

    public FileReaderMessenger(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Supplier<String> readFromFile() {
        Supplier<String> fileReader = () -> {
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
        };
        return fileReader;
    }

    private void closeFile() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
