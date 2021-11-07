package com.experis.sourse;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleReader implements Reader<String> {

    public String read() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals("")) {
            return null;
        }
        return line;
    }

}