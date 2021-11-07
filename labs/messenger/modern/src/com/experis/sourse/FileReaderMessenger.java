package com.experis.sourse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FileReaderMessenger {
    String filePath;

    public FileReaderMessenger(String filePath) {
        this.filePath = filePath;
    }

    public Supplier<String> readFromFile() {
        Supplier<String> fileReader = () -> {
            Stream<String> lines = null;
            try {
                lines = Files.lines(Path.of(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String massege = lines.toString();
            return massege;
        };
        return fileReader;
    }
}
