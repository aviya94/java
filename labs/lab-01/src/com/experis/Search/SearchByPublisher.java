package com.experis.Search;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;
import com.experis.dataBase.EncodedString;

import java.util.ArrayList;
import java.util.function.BiFunction;

class SearchByPublisher implements Search<String> {

    private final DataBase dataBase;
    private SearchResultIndex creatIndexWordArray;
    private ArrayList<EncodedString> publisherResult;
    private ArrayList<Book> bookResult;

    SearchByPublisher(DataBase dataBase, ArrayList<String> ignorList, ArrayList<Book> bookResult) {
        this.dataBase = dataBase;
        this.creatIndexWordArray = creatIndexWordArray = new SearchResultIndex(ignorList, dataBase);
        publisherResult = new ArrayList<EncodedString>();
        this.bookResult = bookResult;
    }

    @Override
    public void search(String choice) {
        String[] choiceWordArr = getArrayWord(choice);
        creatIndexWordArray.search(choiceWordArr);
        publisherResult = creatIndexWordArray.addToResultTitle(dataBase.authors);
        updateBookResult();
    }

    private void updateBookResult() {
        BiFunction<EncodedString, Integer, Integer> comper = (es, index) -> {
            return es.compareTo(bookResult.get(index).publisher);
        };

        AddToBookResult.margeResultToFild(bookResult, publisherResult, comper);
    }

    private String[] getArrayWord(String choice) {
        String wordWithoutSign = CuttingString.catString(choice, "p:\"", "\"", 3);
        String[] choiceWordArr = wordWithoutSign.split(" ");
        return choiceWordArr;
    }
}