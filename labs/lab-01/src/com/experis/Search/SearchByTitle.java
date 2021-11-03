package com.experis.Search;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;
import com.experis.dataBase.EncodedString;

import java.util.ArrayList;

public class SearchByTitle implements Search<String> {

    private final DataBase dataBase;
    private final ArrayList<String> ignorList;
    ArrayList<EncodedString> titleResult;
    public ArrayList<Book> bookResult;
    SearchResultIndex searchResultIndex;

    public SearchByTitle(DataBase dataBase, ArrayList<String> ignorList) {
        this.dataBase = dataBase;
        this.ignorList = ignorList;
        searchResultIndex = new SearchResultIndex(ignorList, dataBase);
    }

    @Override
    public void search(String choice) {
        initialResult();

        String[] choiceWordArr = CuttingString.substringToOnlyTitleWord(choice);
        searchResultIndex.search(choiceWordArr);
        titleResult = searchResultIndex.addToResultTitle(dataBase.booksTitle);
        setResult();
        findAuthorChoice(choice);
        findPublisherChoice(choice);

    }

    private void initialResult() {
        titleResult = new ArrayList<>();
    }

    public void setResult() {

        bookResult = AddToBookResult.addBookResult(dataBase.BooksCatalog, titleResult);
    }

    private void findAuthorChoice(String choice) {

        if (choice.indexOf("a:") >= 0) {
            SearchByAuthor searchByAuthor;
            searchByAuthor = new SearchByAuthor(dataBase, ignorList, bookResult);
            searchByAuthor.search(choice);
        }
    }

    private void findPublisherChoice(String choice) {

        if (choice.indexOf("p:") >= 0) {
            SearchByPublisher searchByPublisher;
            searchByPublisher = new SearchByPublisher(dataBase, ignorList, bookResult);
            searchByPublisher.search(choice);
        }
    }
}