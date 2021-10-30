package com.experis;

import com.experis.Search.SearchByISBN;
import com.experis.Search.SearchByTitle;
import com.experis.dataBase.DataBase;
import com.experis.dataBase.LoadDatabase;
import parser.BookParser;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        DataBase dataBase = new DataBase();
        BookParser bookParser = new BookParser("\\|");
        ArrayList<String> ignorList = new ArrayList<String>();
        ignorList.add("The");
        ignorList.add("is");
        ignorList.add("or");
        ignorList.add("and");
        ignorList.add("to");
        LoadDatabase loadDatabase = new LoadDatabase("C:\\Users\\user\\books-small.txt", bookParser, dataBase);
        Menue menue = new Menue(dataBase, ignorList);

    }
}
