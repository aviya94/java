package com.experis.parser;

public abstract class ItemParser implements Parser {
    String delimited;

    public ItemParser(String delimited) {
        this.delimited = delimited;
    }

}
