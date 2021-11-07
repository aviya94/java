package com.experis.destanation;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileWriterMassenger implements writer<String> {
    private String filePath;
    private BufferedWriter writer;

    public FileWriterMassenger(String filePath) {
        this.filePath = filePath;

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            writer = new BufferedWriter(fileWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String message) {
        if (message == null) {
            closeWrite();

        } else {
            try {
                writer.write(message + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeWrite() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
