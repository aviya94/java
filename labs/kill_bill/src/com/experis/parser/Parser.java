package com.experis.parser;

public interface Parser<T> {
    public T parse(String value);
}
