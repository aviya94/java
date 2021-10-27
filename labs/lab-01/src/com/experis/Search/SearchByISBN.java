package com.experis.Search;

import com.experis.LoadDatabase;
import com.experis.Search.Search;

public class SearchByISBN implements Search {
    private LoadDatabase loadDatabase;
    private String[] searchResult;

    public SearchByISBN(LoadDatabase loadDatabase) {
        this.loadDatabase = loadDatabase;
    }

    public void search(String choice) {

        searchResult = loadDatabase.getBooksCatalogISBN().get(choice);
    }

    public String[] getResult() {

        return searchResult;
    }

    public void print() {

        try {
            System.out.println("ISBN: " + searchResult[0]);
            System.out.println("Title: " + searchResult[1]);
            System.out.println("Author: " + loadDatabase.getAuthors().get(Integer.valueOf(searchResult[2])));
            System.out.println("Year: " + searchResult[3]);
            System.out.println("Publisher: " + loadDatabase.getPublishers().get(Integer.valueOf(searchResult[4])) + "\n");

        } catch (NullPointerException e) {
            System.out.println("book not found");
        }

    }

}
