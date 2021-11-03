package com.experis.dataBase;

import java.util.ArrayList;

abstract class AddToDatabase {
    static void addNewBook(String[] fild, DataBase dataBase) {

        if (fild.length == 5) {
            EncodedString title = putAtDatabse(fild[1], dataBase, dataBase.booksTitle);
            EncodedString author = putAtDatabse(fild[2], dataBase, dataBase.authors);
            EncodedString publisher = putAtDatabse(fild[4], dataBase, dataBase.publishers);
            String year = fild[3].trim();
            addToBookCatalog(fild[0], title.codeStr, author.codeStr, year, publisher.codeStr, dataBase);
        }

    }

    private static EncodedString putAtDatabse(String fild, DataBase dataBase, ArrayList<EncodedString> array) {
        EncodedString fildEncoded = creatNewEncoded(fild, dataBase);
        array.add(fildEncoded);
        return fildEncoded;
    }

    private static EncodedString creatNewEncoded(String fild, DataBase dataBase) {
        EncodedString encodedString = new EncodedString(fild, dataBase.encodedMap);
        return encodedString;
    }

    private static void addToBookCatalog(String isbn, ArrayList<Integer> book, ArrayList<Integer> author, String year, ArrayList<Integer> publisher, DataBase dataBase) {
        Book newBook = new Book(isbn, book, author, year, publisher);
        dataBase.BooksCatalog.put(isbn, newBook);

    }

}
