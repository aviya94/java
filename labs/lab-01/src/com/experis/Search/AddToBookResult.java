package com.experis.Search;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;
import com.experis.dataBase.EncodedString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

abstract class AddToBookResult {


    static ArrayList<Book> addBookResult(HashMap<String, Book> catalog, ArrayList<EncodedString> titleResult) {
        ArrayList<Book> bookResult = new ArrayList<>();
        for (Map.Entry dictionaryWord : catalog.entrySet()) {

            for (EncodedString e : titleResult) {
                Book book = (Book) dictionaryWord.getValue();
                if (book.bookTitle.equals(e.codeStr)) {
                    bookResult.add(book);
                }
            }
        }
        return bookResult;
    }

    static void margeResultToFild(ArrayList<Book> bookResult, ArrayList<EncodedString> fildResult, BiFunction<EncodedString, Integer, Integer> comper) {
        Boolean isContain = false;
        int i = 0;

        while (bookResult.size() != i) {
            for (EncodedString e : fildResult) {
                if (comper.apply(e, i) == 0) {
                    isContain = true;
                    break;
                }
            }
            if (isContain == false) {
                bookResult.remove(bookResult.get(i));

            } else {
                isContain = false;
                i++;
            }
        }
    }

}
