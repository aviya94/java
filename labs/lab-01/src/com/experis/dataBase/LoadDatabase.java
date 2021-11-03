package com.experis.dataBase;

import com.experis.parser.BookParser;

import java.io.*;

public class LoadDatabase {

    private BufferedReader bufferedReader;
    private DataBase dataBase;

    public LoadDatabase(String filePath, BookParser bookPraser, DataBase dataBase) {
        this.dataBase = dataBase;
        loadFile(filePath, bookPraser);
    }

    private void loadFile(String filePath, BookParser bookParser) {

        try (FileReader fileReader = new FileReader(filePath)) {
            bufferedReader = new BufferedReader(fileReader);
            addDataToStructuresDataFromFile(bookParser);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readLine() throws IOException {
        String line = bufferedReader.readLine();
        return line;
    }

    private void addDataToStructuresDataFromFile(BookParser bookPraser) {
        try {
            String line = readLine();

            while ((line = readLine()) != null) {
                String[] filds = bookPraser.parser(line);
                AddToDatabase.addNewBook(filds,dataBase);
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
        }

    }
}

