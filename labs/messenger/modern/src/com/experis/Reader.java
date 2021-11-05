package com.experis.source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Reader {
    String filePath;

    public Reader(String filePath) {
        this.filePath = filePath;
    }

    public  <T> T read(Supplier<T> read) {
        T massege =  read.get();
        return massege;
    }

    public Supplier< String> readFromFile() {
        Supplier< String> fileReader = ()-> {
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

    public Supplier<String> readFromConsole() {
        Supplier<String> consoleReader = () -> {
            Scanner scanner = new Scanner(System.in);
            return scanner.next();
        };
        return consoleReader;

    }
}

