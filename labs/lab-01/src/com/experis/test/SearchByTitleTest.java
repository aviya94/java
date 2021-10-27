package com.experis.test;

import com.experis.LoadDatabase;
import com.experis.Search.SearchByTitle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SearchByTitleTest {
    LoadDatabase loadDatabase;
    SearchByTitle searchByTitle;
    FileInputStream fileInputStream;
    BufferedReader bufferedReader;

    @BeforeEach
    void setup() throws FileNotFoundException {
        loadDatabase = new LoadDatabase("C:\\Users\\user\\books-tons-of.txt");
        searchByTitle = new SearchByTitle(loadDatabase);
        fileInputStream = new FileInputStream("C:\\Users\\user\\books-tons-of.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
    }

    @Test
    @Order(1)
    void Search_not_fount() {

        searchByTitle.search("1111111");
        ArrayList<String[]> resultFind = searchByTitle.getResult();
        assertEquals(0, resultFind.size());

    }

    @Test
    @Order(2)
    void Search_all_name_books_in_catalog() throws IOException {

        String strLine = bufferedReader.readLine();

        for (Map.Entry book : loadDatabase.getBooksCatalogTitel().entrySet()) {

            searchByTitle.search(String.valueOf(book.getKey()));
            ArrayList<String[]> resultFind = searchByTitle.getResult();
            int indexTitle = loadDatabase.getTiteFildlInHashMap().get("Book-Title");

            for (String[] e : resultFind) {
                String key = (String) book.getKey();
                key = key.substring(1, key.length() - 1);
                assertTrue(e[indexTitle].contains(key));
            }

        }


    }

    @Test
    @Order(3)
    void Search_with_words() {
        int indexTitle = loadDatabase.getTiteFildlInHashMap().get("Book-Title");
        String[] wordToFind = {"All Sum", "House The", "end the"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<String[]> resultFind = searchByTitle.getResult();

            for (String e : arrWordToFind) {

                for (String[] lineFind : resultFind) {
                    assertTrue(lineFind[indexTitle].contains(e));
                }

            }
        }
    }

    @Test
    @Order(4)
    void Search_less_words() {
        int indexTitle = loadDatabase.getTiteFildlInHashMap().get("Book-Title");
        String[] wordToFind = {"-The", "-Cider -Russia", "-Kitchen -The"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<String[]> resultFind = searchByTitle.getResult();

            for (String e : arrWordToFind) {
                String wordWithoutLess = e.substring(1, e.length());

                for (String[] lineFind : resultFind) {
                    assertFalse(lineFind[indexTitle].contains(" " + wordWithoutLess + " "));
                }

            }
        }
    }

    @Test
    @Order(5)
    void Search_with_and_less_word() {
        int indexTitle = loadDatabase.getTiteFildlInHashMap().get("Book-Title");
        String[] wordToFind = {"-All Sum", "-House The", "end -the", "-Cider +Russia", "+Kitchen -The"};

        for (String lessWord : wordToFind) {
            String[] arrWordToFind = lessWord.split(" ");
            searchByTitle.search(lessWord);
            ArrayList<String[]> resultFind = searchByTitle.getResult();

            for (String e : arrWordToFind) {

                for (String[] lineFind : resultFind) {

                    if (e.startsWith("-")) {
                        String wordWithoutLess = e.substring(1, e.length());
                        assertFalse(lineFind[indexTitle].contains(" " + wordWithoutLess + " "));

                    } else {
                        assertTrue(lineFind[indexTitle].contains(e));
                    }

                }

            }
        }
    }
}

