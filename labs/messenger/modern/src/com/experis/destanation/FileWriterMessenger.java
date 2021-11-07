package com.experis.destanation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileWriterMessenger {
String filePath;
    BufferedWriter bufferedWriter;
    public FileWriterMessenger(String filePath) {
        this.filePath = filePath;

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            bufferedWriter = new BufferedWriter(fileWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Consumer<String> writeToFile(String message) {
        Consumer<String> fileWriter = (str) -> {
            if (message == null) {
                closeWrite();

            } else {
                try {
                    bufferedWriter.write(message + "\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        return fileWriter;
    }
    public void closeWrite() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
