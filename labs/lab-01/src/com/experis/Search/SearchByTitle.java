package com.experis.Search;

import com.experis.LoadDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByTitle implements Search {
    private LoadDatabase loadDatabase;
    private ArrayList<String[]> searchResult;
    private HashMap<String, String[]> resultWithoutReduction;

    public SearchByTitle(LoadDatabase loadDatabase) {
        this.loadDatabase = loadDatabase;
    }

    public void search(String choice) {
        initialResult();
        String[] choiceWordArr = choice.split(" ");
        addwantedWord(choiceWordArr);
        RemoveUnwantedWord(choiceWordArr);

    }

    private void addwantedWord(String[] choiceWordArr) {
        if (CheckIfHaveOnlyLessWorld(choiceWordArr) == false) ;
        {

            for (String word : choiceWordArr) {

                if (!isLess(word)) {
                    scanCatalogToAddBookToResult(word);
                }
            }
        }
    }

    private void RemoveUnwantedWord(String[] choiceWordArr) {
        for (String word : choiceWordArr) {
            scanCatalogToRemoveFromResult(word);
        }
    }

    private void scanCatalogToRemoveFromResult(String word) {
        for (Map.Entry book : resultWithoutReduction.entrySet()) {
            String key = (String) book.getKey();

            if (isLess(word)) {
                String wordWithoutLess = word.substring(1, word.length());
                removeFromResult(key, wordWithoutLess, book, true);

            } else {
                removeFromResult(key, word, book, false);
            }

        }
    }

    private Boolean CheckIfHaveOnlyLessWorld(String[] choiceWordArr) {
        Boolean onlyLess = true;

        for (String word : choiceWordArr) {
            if (!word.startsWith("-")) {
                onlyLess = false;
            }
        }

        if (onlyLess == true) {
            addAllCatalogToResult();
        }

        return onlyLess;
    }

    private void scanCatalogToAddBookToResult(String word) {
        for (Map.Entry book : loadDatabase.getBooksCatalogTitel().entrySet()) {
            String key = (String) book.getKey();

            if (key.contains(" " + word + " ") && resultWithoutReduction.get(key) == null) {
                addToResult(book);
            }
        }
    }

    private boolean isLess(String word) {
        return word.startsWith("-");
    }

    private void addAllCatalogToResult() {
        for (Map.Entry book : loadDatabase.getBooksCatalogTitel().entrySet()) {
            addToResult(book);
        }
    }

    private void addToResult(Map.Entry book) {
        resultWithoutReduction.put((String) book.getKey(), (String[]) book.getValue());
        searchResult.add((String[]) book.getValue());
    }

    private void removeFromResult(String key, String word, Map.Entry book, Boolean isContainWord) {
        if (key.contains(" " + word + " ") == isContainWord && searchResult.contains(book.getValue())) {
            searchResult.remove((String[]) book.getValue());
        }
    }

    public ArrayList<String[]> getResult() {

        return searchResult;
    }

    public void print() {

        if (searchResult.size() == 0) {
            System.out.println("books not found");

        } else {

            for (String[] line : searchResult) {
                System.out.print(line[0]);
                System.out.print("|" + line[1]);
                System.out.print("|" + loadDatabase.getAuthors().get(Integer.valueOf(line[2])));
                System.out.print("|" + line[3]);
                System.out.println("|" + loadDatabase.getPublishers().get(Integer.valueOf(line[4])));

            }
            System.out.println();
        }
    }

    private void initialResult() {
        searchResult = new ArrayList<String[]>();
        resultWithoutReduction = new HashMap<String, String[]>();
    }

}
