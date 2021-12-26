package com.example.encryptor.sourse;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ConsoleReader implements Reader<String> {

    @Override
    public String read() {
        System.out.println("Enter String:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals("")) {
            return null;
        }
        return line;
    }
}
