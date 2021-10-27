
package com.experis.test;

import com.experis.LoadDatabase;
import com.experis.Search.SearchByISBN;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SearchByISBNtest {
    LoadDatabase loadDatabase;
    SearchByISBN searchByISBN;
    FileInputStream fstream;
    BufferedReader br;

    @BeforeEach
    void setup() throws FileNotFoundException {
        loadDatabase = new LoadDatabase("C:\\Users\\user\\books-tiny.txt");
        searchByISBN = new SearchByISBN(loadDatabase);
        fstream = new FileInputStream("C:\\Users\\user\\books-tiny.txt");
        br = new BufferedReader(new InputStreamReader(fstream));
    }

    @Test
    @Order(1)
    void Search_not_fount() {

        searchByISBN.search("1111111");
        String[] result = searchByISBN.getResult();
        assertEquals(null, result);


    }

    @Test
    @Order(2)
    void Search() throws IOException {

        String strLine = br.readLine();

        for (Map.Entry book : loadDatabase.getBooksCatalogISBN().entrySet()) {

            searchByISBN.search(String.valueOf(book.getKey()));
            String[] ResultFind = searchByISBN.getResult();
            int indexTitleISBN = loadDatabase.getTiteFildlInHashMap().get("ISBN");
            assertEquals(book.getKey(), ResultFind[indexTitleISBN]);

        }

    }


}
