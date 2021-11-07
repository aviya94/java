package com.experis.sourse;

import java.util.Scanner;
import java.util.function.Supplier;

public class ConsoleReader {
    public Supplier<String> readFromConsole() {
        Supplier<String> consoleReader = () -> {
            Scanner scanner = new Scanner(System.in);
            return scanner.next();
        };
        return consoleReader;

    }
}
