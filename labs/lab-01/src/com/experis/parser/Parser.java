package com.experis.parser;

public interface Parser<T> {
    T parser(String line);
}
