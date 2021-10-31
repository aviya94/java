
package com.experis.test;

import com.experis.Search.SearchByTitle;
import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;
import com.experis.Search.SearchByISBN;
import com.experis.dataBase.LoadDatabase;
import com.experis.parser.BookParser;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SearchByISBNtest {

    SearchByISBN searchByISBN;
    DataBase dataBase;
    BookParser bookParser;

    @BeforeEach
    void setup() throws FileNotFoundException {
        dataBase = new DataBase();
        bookParser = new BookParser("\\|");
        LoadDatabase loadDatabase = new LoadDatabase("C:\\Users\\user\\books-tons-of.txt", bookParser, dataBase);
        searchByISBN = new SearchByISBN(dataBase);
    }

    @Test
    @Order(1)
    void Search_not_fount() {
        searchByISBN.search("1111111");
        Book result = searchByISBN.searchResult;
        assertEquals(null, result);

    }

    @Test
    @Order(2)
    void Search() throws IOException {

        for (Map.Entry book : dataBase.BooksCatalog.entrySet()) {
            searchByISBN.search(String.valueOf(book.getKey()));
            Book ResultFind = searchByISBN.searchResult;
            assertEquals(book.getKey(), ResultFind.isbn);

        }

    }

}