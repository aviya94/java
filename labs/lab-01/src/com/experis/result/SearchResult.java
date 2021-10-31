package com.experis.result;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;

import java.util.ArrayList;

public abstract class SearchResult {

    public static String result(Book bookResult, DataBase dataBase) {

        if (bookResult == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ISBN: " + bookResult.isbn + "\n");
        stringBuilder.append("Title: " + dataBase.booksTitle.get(bookResult.bookTitle) + "\n");
        stringBuilder.append("Author: " + dataBase.authors.get(bookResult.bookAuthor) + "\n");
        stringBuilder.append("Year: " + bookResult.year + "\n");
        stringBuilder.append("Publisher: " + dataBase.publishers.get(bookResult.publisher));
        String result = String.valueOf(stringBuilder);
        return result;

    }

    public static String result(ArrayList<Book> booksResult, DataBase dataBase) {

        if (booksResult.size() == 0) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Book book : booksResult) {
            stringBuilder.append(book.isbn + "|");
            stringBuilder.append(dataBase.booksTitle.get(book.bookTitle) + "|");
            stringBuilder.append(dataBase.authors.get(book.bookAuthor) + "|");
            stringBuilder.append(book.year + "|");
            stringBuilder.append(dataBase.publishers.get(book.publisher) + "\n");
        }

        String result = String.valueOf(stringBuilder);
        return result;
    }


}
