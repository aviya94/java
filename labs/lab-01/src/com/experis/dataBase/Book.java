package com.experis.dataBase;


import java.util.ArrayList;

public class Book {
    final public String isbn;
    final public ArrayList<Integer> bookTitle;
    final public ArrayList<Integer> bookAuthor;
    final public String year;
    final public ArrayList<Integer> publisher;

    public Book(String isbn, ArrayList<Integer> bookTitle, ArrayList<Integer> author, String year, ArrayList<Integer> publisher) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = author;
        this.year = year;
        this.publisher = publisher;
    }

}
