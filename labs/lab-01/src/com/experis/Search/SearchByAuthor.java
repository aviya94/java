package com.experis.Search;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;
import com.experis.dataBase.EncodedString;

import java.util.ArrayList;
import java.util.function.BiFunction;

class SearchByAuthor implements Search<String> {
    private final DataBase dataBase;
    private SearchResultIndex searchResultIndex;
    private ArrayList<EncodedString> authorResult;
    private ArrayList<Book> bookResult;

    SearchByAuthor(DataBase dataBase, ArrayList<String> ignorList, ArrayList<Book> bookResult) {
        this.dataBase = dataBase;
        this.searchResultIndex = searchResultIndex = new SearchResultIndex(ignorList, dataBase);
        authorResult = new ArrayList<EncodedString>();
        this.bookResult = bookResult;
    }

    @Override
    public void search(String choice) {
        String[] choiceWordArr = getArrayWord(choice);
        searchResultIndex.search(choiceWordArr);
        authorResult = searchResultIndex.addToResultTitle(dataBase.authors);
        updateBookResult();

    }

    private void updateBookResult() {
        BiFunction<EncodedString, Integer, Integer> comper = (es, index) -> {
            return es.compareTo(bookResult.get(index).bookAuthor);
        };

        AddToBookResult.margeResultToFild(bookResult, authorResult, comper);
    }

    private String[] getArrayWord(String choice) {
        String wordWithoutSign = CuttingString.catString(choice, "a:\"", "\"", 3);
        String[] choiceWordArr = wordWithoutSign.split(" ");
        return choiceWordArr;
    }
}