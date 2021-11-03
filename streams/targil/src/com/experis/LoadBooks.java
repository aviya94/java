package com.experis;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LoadBooks {
    String fileName;

    public LoadBooks(String fileName) {

        this.fileName = fileName;
    }

    public void load(BookParser bookPraser) throws IOException {
        final Stream<String> lines = Files.lines(Path.of(fileName));
        var books = lines.skip(1)
                .filter(line -> line.trim().length() > 0)
                .map(l -> {
                    return bookPraser.parser(l);
                });

    }
}