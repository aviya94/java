package com.experis.destanation;


public class ConsoleWriter implements writer<String> {
    public void writh(String message) {
            System.out.println(message);
    }
}
