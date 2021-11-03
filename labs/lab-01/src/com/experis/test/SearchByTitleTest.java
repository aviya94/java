package com.experis.test;

import com.experis.dataBase.Book;
import com.experis.parser.BookParser;
import com.experis.dataBase.DataBase;
import com.experis.dataBase.LoadDatabase;
import com.experis.Search.SearchByTitle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SearchByTitleTest {
    DataBase dataBase;
    LoadDatabase loadDatabase;
    SearchByTitle searchByTitle;
    BookParser bookParser;
    private ArrayList<String> ignorList;

    @BeforeEach
    void setup() throws FileNotFoundException {
        bookParser = new BookParser("\\|");
        dataBase = new DataBase();
        LoadDatabase loadDatabase = new LoadDatabase("C:\\Users\\user\\books-small.txt", bookParser, dataBase);
        ignorList = new ArrayList<String>();
        searchByTitle = new SearchByTitle(dataBase, ignorList);
    }

    @Test
    @Order(1)
    void Search_not_fount() {

        searchByTitle.search("1111111");
        ArrayList<Book> resultFind = searchByTitle.bookResult;
        assertEquals(0, resultFind.size());
    }

    @Test
    @Order(3)
    void Search_with_words() {
        ignorList = null;
        String[] wordToFind = {"Wife Kitchen"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.bookResult;

            for (String e : arrWordToFind) {

                for (Book lineFind : resultFind) {
                    int resultIndex = dataBase.getIndex(dataBase.booksTitle, lineFind.bookTitle);
                    String resultTitle = dataBase.booksTitle.get(resultIndex).toString();
                    String[] resultArr = resultTitle.split(" ");
                    assertTrue(isOK(e, resultArr));
                }

            }
        }
    }

    @Test
    @Order(4)
    void Search_less_words() {
        ignorList = null;
        String[] wordToFind = {"-The", "-Cider -Russia", "-Kitchen -The"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.bookResult;

            for (String e : arrWordToFind) {
                String wordWithoutLess = e.substring(1, e.length());

                for (Book lineFind : resultFind) {
                    int resultIndex = dataBase.getIndex(dataBase.booksTitle, lineFind.bookTitle);
                    String resultTitle = dataBase.booksTitle.get(resultIndex).toString();
                    String[] resultArr = resultTitle.split(" ");
                    assertFalse(isOK(wordWithoutLess, resultArr));
                }

            }
        }
    }

    @Test
    @Order(5)
    void Search_with_and_less_word() {
        ignorList = null;
        String[] wordToFind = {"+The -House +Book +Answers"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.bookResult;

            for (String e : arrWordToFind) {

                for (Book lineFind : resultFind) {

                    if (e.startsWith("-")) {
                        String wordWithoutLess = e.substring(1, e.length());
                        int resultIndex = dataBase.getIndex(dataBase.booksTitle, lineFind.bookTitle);
                        String resultTitle = dataBase.booksTitle.get(resultIndex).toString();
                        String[] resultArr = resultTitle.split(" ");
                        assertFalse(isOK(wordWithoutLess, resultArr));

                    } else {
                        String wordWithoutPlus = e.substring(1, e.length());
                        int resultIndex = dataBase.getIndex(dataBase.booksTitle, lineFind.bookTitle);
                        String resultTitle = dataBase.booksTitle.get(resultIndex).toString();
                        String[] resultArr = resultTitle.split(" ");
                        assertTrue(isOK(wordWithoutPlus, resultArr));
                    }

                }

            }
        }
    }

    private Boolean isOK(String wordWithoutPlus, String[] resultArr) {
        Boolean isOk = false;
        for (String word : resultArr) {
            if (word.equals(wordWithoutPlus)) {
                isOk = true;
                assertTrue(true);
            }
        }
        return isOk;
    }

    @Test
    @Order(5)
    void Search_with_author() {
        ignorList = null;
        String[] wordToFind = {"a:\"E. J. W. Barber\"", "a:\"Richard Bruce Wright\"", "a:\"R. J. Kaiser\"", "\"a:John Grisham\""};

        for (String lessWord : wordToFind) {
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.bookResult;

            String wordWithoutSign = lessWord.substring(lessWord.indexOf("a:\"") + 3);
            wordWithoutSign = wordWithoutSign.substring(0, wordWithoutSign.indexOf("\""));
            for (Book lineFind : resultFind) {
                int resultIndex = dataBase.getIndex(dataBase.authors, lineFind.bookAuthor);
                String resultAuthor = dataBase.authors.get(resultIndex).toString();
                assertTrue(resultAuthor.contains(wordWithoutSign));
            }
        }

    }

    @Test
    @Order(6)
    void Search_with_and_less_and_author() {
        ignorList = null;
        String[] wordToFind = {"+Calla a:\"Richard\""};

        for (String lessWord : wordToFind) {
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.bookResult;
            String less = lessWord.substring(1, lessWord.indexOf(" "));
            String plus = lessWord.substring(lessWord.indexOf(" ") + 1);
            plus = plus.substring(0, lessWord.indexOf(" ") - 1);
            String author = lessWord.substring(lessWord.indexOf("a:\"") + 3);
            author = author.substring(0, author.indexOf("\"") - 1);

            for (Book lineFind : resultFind) {
                int resultIndexAuthor = dataBase.getIndex(dataBase.authors, lineFind.bookAuthor);
                String resultAuthor = dataBase.authors.get(resultIndexAuthor).toString();
                int resultIndexPub = dataBase.getIndex(dataBase.booksTitle, lineFind.bookTitle);
                String resultTitle = dataBase.booksTitle.get(resultIndexPub).toString();
                String[] resultTitleArr = resultTitle.split(" ");
                String[] resultAuthorArr = resultAuthor.split(" ");
                assertTrue(isOK(author, resultAuthorArr));
                assertFalse(isOK(less, resultTitleArr));
                assertTrue(isOK(plus, resultTitleArr));
            }
        }
    }


    @Test
    @Order(7)
    void Search_ignor_list() {
        String[] wordToFind = {"The", "is", "or", "and", "to"};
        ignorList.add("The");
        ignorList.add("is");
        ignorList.add("or");
        ignorList.add("and");
        ignorList.add("to");

        for (String lessWord : wordToFind) {
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.bookResult;
            assertEquals(0, resultFind.size());
        }
    }


}




