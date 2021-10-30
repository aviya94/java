package com.experis.Search;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;

public class SearchByISBN implements Search {

    private DataBase dataBase;
    private Book searchResult;

    public SearchByISBN(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void search(String choice) {
        searchResult = dataBase.BooksCatalog.get(choice);
    }

    public Book getResult() {

        return searchResult;

    }

}
