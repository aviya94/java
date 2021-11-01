package com.experis.parser;

public interface Parser<T extends Object> {
    T parser(String line);
}
