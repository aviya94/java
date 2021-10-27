package com.experis.Search;

import com.experis.LoadDatabase;
import com.experis.Search.Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SearchByTitle implements Search {
    private LoadDatabase loadDatabase;
    private ArrayList<String[]> searchResult;

    public SearchByTitle(LoadDatabase loadDatabase) {
        this.loadDatabase = loadDatabase;
    }

    public void search(String choice) {
        initialSearchResult();
        HashMap<String, String[]> containWordSelected = new HashMap<String, String[]>();

        String[] choiceWordArr = choice.split(" ");

        addwantedWord(choiceWordArr, containWordSelected);
        RemoveUnwantedWord(choiceWordArr, containWordSelected);

    }

    private void initialSearchResult() {
        searchResult = new ArrayList<String[]>();
    }

    private void addwantedWord(String[] choiceWordArr, HashMap<String, String[]> containWordSelected) {

        if (CheckOnlyLessWorld(choiceWordArr, containWordSelected) == false) ;
        {
            for (String word : choiceWordArr) {

                if (!word.startsWith("-")) {

                    for (Map.Entry book : loadDatabase.getBooksCatalogTitel().entrySet()) {
                        String key = (String) book.getKey();

                        if (key.contains(word) && containWordSelected.get(key) == null) {
                            containWordSelected.put((String) book.getKey(), (String[]) book.getValue());
                            searchResult.add((String[]) book.getValue());
                        }
                    }
                }
            }
        }
    }

    private Boolean CheckOnlyLessWorld(String[] choiceWordArr, HashMap<String, String[]> containWordSelected) {
        Boolean onlyLess = true;
        for (String word : choiceWordArr) {
            if (!word.startsWith("-")) {
                onlyLess = false;
            }
        }
        if (onlyLess == true) {
            for (Map.Entry book : loadDatabase.getBooksCatalogTitel().entrySet()) {
                containWordSelected.put((String) book.getKey(), (String[]) book.getValue());
                searchResult.add((String[]) book.getValue());
            }
        }
        return onlyLess;
    }

    private void RemoveUnwantedWord(String[] choiceWordArr, HashMap<String, String[]> containWordSelected) {

        for (String word : choiceWordArr) {

            if (word.startsWith("-")) {

                for (Map.Entry book : containWordSelected.entrySet()) {

                    String key = (String) book.getKey();
                    String wordWithoutLess = word.substring(1, word.length());

                    if (key.contains(wordWithoutLess) && searchResult.contains(book.getValue())) {
                        searchResult.remove((String[]) book.getValue());
                    }
                }
            } else {

                for (Map.Entry book : containWordSelected.entrySet()) {
                    String key = (String) book.getKey();
                    if (!key.contains(word) && searchResult.contains(book.getValue())) {
                        searchResult.remove((String[]) book.getValue());
                    }
                }
            }

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

}
