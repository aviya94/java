package com.experis.destanation;

import java.util.function.Consumer;

public class ConsoleWriter {
    public Consumer<String> writhToConsole(String massage) {
        Consumer<String> consoleWriter = (str) -> {
            System.out.println(str);
        };
        return consoleWriter;
    }
}
