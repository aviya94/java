package com.experis.dataBase;

import com.experis.dataBase.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    final public HashMap<String, Book> BooksCatalog = new HashMap<String, Book>();
    final public HashMap<Integer, String> publishers = new HashMap<Integer, String>();
    final public HashMap<Integer, String> authors = new HashMap<Integer, String>();
    final public HashMap<String, String> isbnAndBooks = new HashMap<String, String>();
    final public HashMap<Integer, String> books = new HashMap<Integer, String>();
    final public HashMap<String, ArrayList<Integer>> dictionaryTitle = new HashMap<String, ArrayList<Integer>>();
    int publishersIndex = 0;
    int authorsIndex = 0;
    int booksIndex = 0;

    public void addNewBook(String[] fild) {
        addToIsbnAndBooks(fild[0], fild[1]);
        int bookTitleIndex = addToBooks(fild[1]);
        int authorIndex = addAuthor(fild[2]);
        int publisherIndex = addPublishersr(fild[4]);
        addToBookCatalog(fild[0], bookTitleIndex, authorIndex, Integer.valueOf(fild[3]), publisherIndex);

    }

    private void addToBookCatalog(String isbn, int book, int author, int year, int publisher) {
        Book newBook = new Book(isbn, book, author, year, publisher);
        BooksCatalog.put(isbn, newBook);

    }

    private int addIndexToFildStructurData(String fild, Integer nextIndex, int indexInFild, HashMap<Integer, String> hashMapToSaveFild) {
        assert fild != null;
        assert hashMapToSaveFild != null;

        Boolean isExist = false;

        for (Map.Entry e : hashMapToSaveFild.entrySet()) {
            String value = (String) e.getValue();

            if (value.equals(fild)) {
                isExist = true;
                fild = String.valueOf(e.getKey());
                return (Integer) e.getKey();
            }
        }

        if (!isExist) {

            hashMapToSaveFild.put(nextIndex, fild);

        }

        return nextIndex;
    }

    private void addToDictionaryTitle(String[] bookTitle, int indexBook) {

        for (String e : bookTitle) {

            if (dictionaryTitle.get(e) == null) {
                ArrayList<Integer> wordIndex = new ArrayList<Integer>();
                wordIndex.add(indexBook);
                dictionaryTitle.put(e, wordIndex);

            } else {
                dictionaryTitle.get(e).add(indexBook);
            }
        }
    }

    private int addToBooks(String fild) {
        books.put(booksIndex, fild);
        String[] bookTitle = fild.split(" ");
        addToDictionaryTitle(bookTitle, booksIndex);
        return booksIndex++;

    }

    private void addToIsbnAndBooks(String isbn, String title) {
        isbnAndBooks.put(title, isbn);
    }

    private int addAuthor(String fild) {
        assert fild != null;
        int index = addIndexToFildStructurData(fild, authorsIndex, 2, authors);

        if (checkIfIndexNotChange(index, authorsIndex)) {
            authorsIndex++;
        }
        return index;
    }

    private int addPublishersr(String fild) {
        assert fild != null;

        int index = addIndexToFildStructurData(fild, publishersIndex, 4, publishers);

        if (checkIfIndexNotChange(index, publishersIndex)) {
            publishersIndex++;
        }

        return index;
    }

    private Boolean checkIfIndexNotChange(int index, int indexToCheck) {
        return index == indexToCheck;
    }


}
