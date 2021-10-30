package com.experis.dataBase;


public class Book {
    final public String isbn;
    final public int bookTitle;
    final public int bookAuthor;
    final public int year;
    final public int publisher;

    public Book(String isbn, int book, int author, int year, int publisher) {
        this.isbn = isbn;
        this.bookTitle = book;
        this.bookAuthor = author;
        this.year = year;
        this.publisher = publisher;
    }

}
