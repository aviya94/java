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
        LoadDatabase loadDatabase = new LoadDatabase("C:\\Users\\user\\books-tons-of.txt", bookParser, dataBase);
        ignorList = new ArrayList<String>();
        searchByTitle = new SearchByTitle(dataBase, ignorList);
    }

    @Test
    @Order(1)
    void Search_not_fount() {

        searchByTitle.search("1111111");
        ArrayList<Book> resultFind = searchByTitle.searchResult;
        assertEquals(0, resultFind.size());

    }

    @Test
    @Order(3)
    void Search_with_words() {
        String[] wordToFind = {"House The", "end the", "Cider Russia", "Kitchen The"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.searchResult;

            for (String e : arrWordToFind) {

                for (Book lineFind : resultFind) {
                    String resultTitle = dataBase.booksTitle.get(lineFind.bookTitle);
                    assertTrue(resultTitle.contains(e));
                }

            }
        }
    }

    @Test
    @Order(4)
    void Search_less_words() {
        String[] wordToFind = {"-The", "-Cider -Russia", "-Kitchen -The"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.searchResult;

            for (String e : arrWordToFind) {
                String wordWithoutLess = e.substring(1, e.length());

                for (Book lineFind : resultFind) {
                    String resultTotle = dataBase.booksTitle.get(lineFind.bookTitle);
                    assertFalse(resultTotle.contains(e));
                }

            }
        }
    }

    @Test
    @Order(5)
    void Search_with_and_less_word() {
        String[] wordToFind = {"-All +Sum", "-House The", "+end -the", "-Cider +Russia", "+Kitchen -The"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.searchResult;

            for (String e : arrWordToFind) {

                for (Book lineFind : resultFind) {

                    if (e.startsWith("-")) {
                        String wordWithoutLess = e.substring(1, e.length());
                        String resultTitle = dataBase.booksTitle.get(lineFind.bookTitle);
                        assertFalse(resultTitle.contains(e));

                    } else {
                        String resultTitle = dataBase.booksTitle.get(lineFind.bookTitle);
                        assertTrue(resultTitle.contains(e));
                    }

                }

            }
        }
    }

    @Test
    @Order(5)
    void Search_with_author() {
        String[] wordToFind = {"a:\"E. J. W. Barber\"", "a:\"Richard Bruce Wright\"", "a:\"R. J. Kaiser\"", "\"a:John Grisham\""};

        for (String lessWord : wordToFind) {
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.searchResult;

            String wordWithoutSign = lessWord.substring(lessWord.indexOf("a:\"") + 3);
            wordWithoutSign = wordWithoutSign.substring(0, wordWithoutSign.indexOf("\""));
            for (Book lineFind : resultFind) {
                String resultAuthor = dataBase.authors.get(lineFind.bookAuthor);
                assertTrue(resultAuthor.contains(wordWithoutSign));
            }
        }

    }

    @Test
    @Order(6)
    void Search_with_and_less_and_author() {
        String[] wordToFind = {"-All Sum a:\"E. J. W. Barber\"", "-House Thea a:\"Richard Bruce Wright\"", "+end -the a:\"R. J. Kaiser\"", "the -and a:\"John Grisham\""};

        for (String lessWord : wordToFind) {
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.searchResult;
            String less = lessWord.substring(1, lessWord.indexOf(" "));
            String plus = lessWord.substring(lessWord.indexOf(" ") + 1);
            plus = plus.substring(0, lessWord.indexOf(" ") - 1);
            String author = lessWord.substring(lessWord.indexOf("a:\"") + 3);
            author = author.substring(0, author.indexOf("\"") - 1);

            for (Book lineFind : resultFind) {
                String resultAuthor = dataBase.authors.get(lineFind.bookAuthor);
                String resultTitle = dataBase.booksTitle.get(lineFind.bookTitle);
                assertTrue(resultAuthor.contains(author));
                assertFalse(resultTitle.contains(less));
                assertTrue(resultTitle.contains(plus));
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
            ArrayList<Book> resultFind = searchByTitle.searchResult;
            assertEquals(0, resultFind.size());
        }
    }

}




