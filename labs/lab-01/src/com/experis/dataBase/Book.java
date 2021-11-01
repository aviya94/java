package com.experis.dataBase;


public class Book {
    final public String isbn;
    final public int bookTitle;
    final public int bookAuthor;
    final public String year;
    final public int publisher;

    public Book(String isbn, int bookTitle, int author, String year, int publisher) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = author;
        this.year = year;
        this.publisher = publisher;
    }

}
