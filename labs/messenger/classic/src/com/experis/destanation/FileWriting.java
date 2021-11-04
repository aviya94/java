package com.experis.destanation;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriting implements Writing<String> {
    String filePath;

    public FileWriting(String filePath) {
        this.filePath = filePath;
    }

    public void writh(String message) {

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
