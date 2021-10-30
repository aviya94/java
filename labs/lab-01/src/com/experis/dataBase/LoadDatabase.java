package com.experis;

import java.io.*;

public class LoadDatabase {
    //private FileInputStream fileInputStream;
    private BufferedReader bufferedReader;
    private DataBase dataBase;
    private BookParser parser;
    private FileInputStream fileInputStream;

    public LoadDatabase(String filePath, BookParser bookPraser,DataBase dataBase)  {
        try {
        this.dataBase=dataBase;
        bufferedReader = new BufferedReader(new FileReader(filePath));


            addDataToStructuresDataFromFile(bookPraser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parser = bookPraser;
    }

    private void loadFile(String filePath) {

        try {
            bufferedReader = new BufferedReader(new FileReader(String.valueOf(filePath)));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    private String readLine() throws IOException {
        String line = bufferedReader.readLine();
        return line;
    }

    private void addDataToStructuresDataFromFile(BookParser bookPraser) throws IOException {

        String line = readLine();

        while ((line = readLine()) != null) {
            String[] filds = bookPraser.parser(line);
            dataBase.addNewBook(filds);
        }


    }

}

