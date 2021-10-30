
package com.experis.test;

import com.experis.dataBase.Book;
import com.experis.dataBase.DataBase;
import com.experis.Search.SearchByISBN;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SearchByISBNtest {

    SearchByISBN searchByISBN;
    DataBase dataBase;

    @BeforeEach
    void setup() throws FileNotFoundException {
        dataBase = new DataBase();
        searchByISBN = new SearchByISBN(dataBase);

    }

    @Test
    @Order(1)
    void Search_not_fount() {
        searchByISBN.search("1111111");
        Book result = searchByISBN.getResult();
        assertEquals(null, result);

    }

    @Test
    @Order(2)
    void Search() throws IOException {

        for (Map.Entry book : dataBase.BooksCatalog.entrySet()) {
            searchByISBN.search(String.valueOf(book.getKey()));
            Book ResultFind = searchByISBN.getResult();
            assertEquals(book.getKey(), ResultFind.isbn);

        }

    }

}
