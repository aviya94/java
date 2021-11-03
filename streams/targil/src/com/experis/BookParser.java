package com.experis;

public class BookParser {
    private final String buffer;

    public BookParser(String buffer) {
        this.buffer = buffer;
    }

    public String[] parser(String line) {
        return line.split(buffer);
    }
}

