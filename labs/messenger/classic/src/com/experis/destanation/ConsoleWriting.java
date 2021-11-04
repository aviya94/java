package com.experis.destanation;


public class ConsoleWriting implements Writing<String> {
    public void writh(String message) {
            System.out.println(message);
    }
}
