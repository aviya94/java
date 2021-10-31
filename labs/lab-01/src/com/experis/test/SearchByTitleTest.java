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
    FileInputStream fileInputStream;
    BufferedReader bufferedReader;
    BookParser bookParser;
    private ArrayList<String> ignorList;

    @BeforeEach
    void setup() throws FileNotFoundException {
        bookParser = new BookParser("\\|");
        dataBase = new DataBase();
        LoadDatabase loadDatabase = new LoadDatabase("C:\\Users\\user\\books-small.txt", bookParser, dataBase);
        ignorList = new ArrayList<String>();
        searchByTitle = new SearchByTitle(dataBase, ignorList);
        fileInputStream = new FileInputStream("C:\\Users\\user\\books-small.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
    }

    @Test
    @Order(1)
    void Search_not_fount() {

        searchByTitle.search("1111111");
        ArrayList<Book> resultFind = searchByTitle.getResult();
        assertEquals(0, resultFind.size());

    }

    @Test
    @Order(3)
    void Search_with_words() {
        String[] wordToFind = {"House The", "end the", "Cider Russia", "Kitchen The"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.getResult();

            for (String e : arrWordToFind) {

                for (Book lineFind : resultFind) {
                    String resultTitle = dataBase.books.get(lineFind.bookTitle);
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
            ArrayList<Book> resultFind = searchByTitle.getResult();

            for (String e : arrWordToFind) {
                String wordWithoutLess = e.substring(1, e.length());

                for (Book lineFind : resultFind) {
                    String resultTotle = dataBase.books.get(lineFind.bookTitle);
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
            ArrayList<Book> resultFind = searchByTitle.getResult();

            for (String e : arrWordToFind) {

                for (Book lineFind : resultFind) {

                    if (e.startsWith("-")) {
                        String wordWithoutLess = e.substring(1, e.length());
                        String resultTotle = dataBase.books.get(lineFind.bookTitle);
                        assertFalse(resultTotle.contains(e));

                    } else {
                        String resultTitle = dataBase.books.get(lineFind.bookTitle);
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
            ArrayList<Book> resultFind = searchByTitle.getResult();

            String wordWithoutSign = lessWord.substring(lessWord.indexOf("a:\"") + 3);
            wordWithoutSign = wordWithoutSign.substring(0, wordWithoutSign.indexOf("\""));
            for (Book lineFind : resultFind) {
                String resultAuthor = dataBase.authors.get(lineFind.bookAuthor);
                assertTrue(resultAuthor.contains(wordWithoutSign));
            }
        }

    }
/*
    @Test
    @Order(6)
    void Search_with_and_less_and_author() {
        String[] wordToFind = {"-All +Sum a:\"E. J. W. Barber\"", "-House Thea a:\"Richard Bruce Wright\"", "+end -the a:\"R. J. Kaiser\"", "the -and a:\"John Grisham\""};

        for (String lessWord : wordToFind) {
            searchByTitle.search(lessWord);
            ArrayList<Book> resultFind = searchByTitle.getResult();

            String wordWithoutSign = lessWord.substring(lessWord.indexOf("a:\"") + 3);
            wordWithoutSign = wordWithoutSign.substring(0, wordWithoutSign.indexOf("\""));
            for (Book lineFind : resultFind) {
                String resultAuthor = dataBase.authors.get(lineFind.bookAuthor);
                assertTrue(resultAuthor.contains(wordWithoutSign));

            }

        }


    }

 */
}




