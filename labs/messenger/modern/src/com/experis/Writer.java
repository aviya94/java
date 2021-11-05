package com.experis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class Writer {
    String filePath;

    public Writer(String filePath) {
        this.filePath = filePath;
    }

    public <T> void write(T massege, Consumer<T> writh) {
        writh.accept(massege);
    }

    public Consumer<String> writhToConsole(String massege) {
        Consumer<String> consoleWriter = (str) -> {
            System.out.println(str);
        };
        return consoleWriter;
    }

    public Consumer<String> writhToFile(String massege) {
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
