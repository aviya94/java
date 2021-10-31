package com.experis.Search;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;

public class SearchByISBN implements Search {

    final private DataBase dataBase;
    public Book searchResult;

    public SearchByISBN(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void search(String choice) {
        searchResult = dataBase.BooksCatalog.get(choice);
    }

}
