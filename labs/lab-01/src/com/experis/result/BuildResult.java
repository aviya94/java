package com.experis.result;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;
import com.experis.dataBase.EncodedString;

import java.util.ArrayList;

public abstract class BuildResult {

    public static String result(Book bookResult, DataBase dataBase) {

        if (bookResult == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ISBN: " + bookResult.isbn + "\n");
        int titleIndex = dataBase.getIndex(dataBase.booksTitle,bookResult.bookTitle);
        stringBuilder.append("Title: " + dataBase.booksTitle.get(titleIndex).toString() + "\n");
        int authorIndex = dataBase.getIndex(dataBase.authors,bookResult.bookAuthor);
        stringBuilder.append("Author: " + dataBase.authors.indexOf(dataBase.authors.get(authorIndex).toString()) + "\n");
        stringBuilder.append("Year: " + bookResult.year + "\n");
        int publisher = dataBase.getIndex(dataBase.publishers,bookResult.publisher);
        stringBuilder.append("Publisher: " + dataBase.publishers.get(publisher).toString());
        String result = String.valueOf(stringBuilder);
        return result;

    }

    public static String result(ArrayList<Book> bookResult, DataBase dataBase) {

        if (bookResult.size() == 0) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Book book : bookResult) {
            int titleIndex = dataBase.getIndex(dataBase.booksTitle,book.bookTitle);
            int authorIndex = dataBase.getIndex(dataBase.authors,book.bookAuthor);
            int publisher = dataBase.getIndex(dataBase.publishers,book.publisher);
            stringBuilder.append(book.isbn + "|");
            stringBuilder.append(dataBase.booksTitle.get(titleIndex).toString() + "|");
            stringBuilder.append(dataBase.authors.get(authorIndex).toString() + "|");
            stringBuilder.append(book.year + "|");
            stringBuilder.append(dataBase.publishers.get(publisher).toString()+ "\n");
        }

        String result = String.valueOf(stringBuilder);
        return result;
    }


}
