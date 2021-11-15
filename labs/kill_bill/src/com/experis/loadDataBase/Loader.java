package com.experis.loadDataBase;

import com.experis.parser.ItemParser;
import com.experis.parser.Parser;

import java.io.*;

public abstract class Loader {
    protected Parser parser;
    protected FileReader fileReader;
    protected BufferedReader bufferedReader;

    public Loader(Parser parser,String filePath) {
        this.parser = parser;

        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (fileReader != null) fileReader.close();
            if (bufferedReader != null) bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
