package com.experis.sourse;

import java.util.Scanner;
import java.util.function.Function;

public  class ConsoleReader implements Reader<String>{
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}