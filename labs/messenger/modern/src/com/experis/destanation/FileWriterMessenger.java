package com.experis.destanation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileWriterMessenger {
String filePath;

    public FileWriterMessenger(String filePath) {
        this.filePath = filePath;
    }

    public Consumer<String> writeToFile(String message) {
        Consumer<String> fileWriter = (str) -> {
            Stream<String> lines = null;
            try {
                lines = (Stream<String>) Files.write(Paths.get(filePath), Collections.singleton(str));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        return fileWriter;
    }
}
