package parser;

import parser.Parser;

public class BookParser implements Parser<String[]> {
    private final String buffer;

    public BookParser(String buffer) {
        this.buffer = buffer;
    }

    public String[] parser(String line){
        return line.split(buffer);
    }
}
