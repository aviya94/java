package com.experis.destanation;


import java.io.FileWriter;
import java.io.IOException;

public class FileWriterr implements writer<String> {
    String filePath;

    public FileWriterr(String filePath) {
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
