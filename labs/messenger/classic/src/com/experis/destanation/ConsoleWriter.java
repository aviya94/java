package com.experis.destanation;


import java.util.ArrayList;

public class ConsoleWriter implements writer<String> {
    public void write(String message) {
        System.out.println(message);
    }
}
