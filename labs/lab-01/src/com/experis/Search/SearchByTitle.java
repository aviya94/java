package com.experis.Search;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;

import java.util.ArrayList;
import java.util.Map;

public class SearchByTitle implements Search<String> {

    final private DataBase dataBase;
    public ArrayList<Book> searchResult;
    final private ArrayList<String> ignorList;
    private ArrayList<Integer> resultsIndex;

    public SearchByTitle(DataBase dataBase, ArrayList<String> ignorList) {
        this.dataBase = dataBase;
        this.ignorList = ignorList;
    }

    @Override
    public void search(String choice) {
        initialResult();
        String[] choiceWordArr = choice.split(" ");
        search(choiceWordArr);
        findAuthorChoice(choice);

    }

    private void initialResult() {
        searchResult = new ArrayList<Book>();
        resultsIndex = new ArrayList<Integer>();
    }

    private void search(String[] choiceWordsArr) {

        for (Map.Entry dictionaryWord : dataBase.dictionaryTitle.entrySet()) {
            addwantedWord(choiceWordsArr, dictionaryWord);
        }

        removeBookNoContainAllWord(choiceWordsArr);

        for (Map.Entry dictionaryWord : dataBase.dictionaryTitle.entrySet()) {
            removeUnwontedWords(choiceWordsArr, dictionaryWord);
        }
        addToSearchResult();
    }

    private void addwantedWord(String[] choiceWordsArr, Map.Entry dictionaryWord) {

        for (String choiceWord : choiceWordsArr) {

            if (chekIfIsProperWorldToInsert(choiceWord)) {
                String dictionaryKey = (String) dictionaryWord.getKey();
                String word = choiceWord;
                word = isStartWithPlus(choiceWord, word);

                if (word.equals(dictionaryKey)) {

                    ArrayList<Integer> dictionaryValue = (ArrayList<Integer>) dictionaryWord.getValue();
                    addBookToResultIndex(dictionaryValue);
                }
            }
        }
    }

    private boolean chekIfIsProperWorldToInsert(String choiceWord) {
        return isStartWhith(choiceWord, "-") == false && ignorList.indexOf(choiceWord) == -1;
    }

    private void addBookToResultIndex(ArrayList<Integer> dictionaryValue) {
        int sizeResult = dictionaryValue.size();

        if (sizeResult == 0) {
            resultsIndex.addAll(dictionaryValue);

        } else {
            for (int i = 0; i < sizeResult; i++) {

                if (resultsIndex.indexOf(dictionaryValue.get(i)) == -1) {
                    resultsIndex.add(dictionaryValue.get(i));
                }
            }
        }
    }

    private void removeBookNoContainAllWord(String[] choiceWordsArr) {

        for (String choiceWord : choiceWordsArr) {

            if (chekIfIsProperWorldToInsert(choiceWord)) {
                String word = choiceWord;
                word = isStartWithPlus(choiceWord, word);
                int index = 0;

                while (index != resultsIndex.size()) {
                    String bookTitle = dataBase.booksTitle.get(resultsIndex.get(index));
                    if (bookTitle.contains(word) == false) {
                        resultsIndex.remove(index);
                    } else {
                        index++;
                    }
                }
            }
        }
    }

    private String isStartWithPlus(String choiceWord, String word) {
        if (isStartWhith(choiceWord, "+")) {
            word = word.substring(1);
        }
        return word;
    }

    private void removeUnwontedWords(String[] choiceWordsArr, Map.Entry dictionaryWord) {

        for (String choiceWord : choiceWordsArr) {

            if (isStartWhith(choiceWord, "-")) {
                String wordWithoutSign = choiceWord.substring(1, choiceWord.length());
                String dictionaryKey = (String) dictionaryWord.getKey();

                if (wordWithoutSign.equals(dictionaryKey)) {
                    ArrayList<Integer> dictionaryValue = (ArrayList<Integer>) dictionaryWord.getValue();

                    for (int e : dictionaryValue) {
                        int index = resultsIndex.indexOf(e);
                        if (index >= 0) {
                            resultsIndex.remove(index);
                        }
                    }
                }
            }
        }
    }

    private void findAuthorChoice(String choice) {

        if (choice.indexOf("a:") >= 0) {

            String wordWithoutSign = choice.substring(choice.indexOf("a:\"") + 3);
            wordWithoutSign = wordWithoutSign.substring(0, wordWithoutSign.indexOf("\""));
            SearchByAuthor searchByAuthor = new SearchByAuthor(searchResult, dataBase);
            searchByAuthor.search(wordWithoutSign);
        }
    }

    private boolean isStartWhith(String choiceWord, String sign) {
        return choiceWord.startsWith(sign);
    }

    private void addToSearchResult() {

        for (int e : resultsIndex) {
            String bookTitle = dataBase.booksTitle.get(e);
            searchResult.add(dataBase.BooksCatalog.get(dataBase.isbnAndBooksTitle.get(bookTitle)));
        }
    }

    private static class SearchByAuthor implements Search<String> {
        DataBase dataBase;
        ArrayList<Book> searchResultTitle;

        public SearchByAuthor(ArrayList<Book> searchResultTitle, DataBase dataBase) {
            this.searchResultTitle = searchResultTitle;
            this.dataBase = dataBase;
        }

        @Override
        public void search(String choice) {

            for (int i = 0; i < searchResultTitle.size(); i++) {
                String author = dataBase.authors.get(searchResultTitle.get(i).bookAuthor);

                if (author.equals(choice) == false) {
                    searchResultTitle.remove(searchResultTitle.get(i));
                }
            }
        }
    }
}
