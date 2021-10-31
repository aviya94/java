package com.experis.test;

import com.experis.dataBase.Book;
import com.experis.parser.BookParser;
import com.experis.dataBase.DataBase;
import com.experis.dataBase.LoadDatabase;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoadDatabaseTest {
    DataBase dataBase;
    LoadDatabase loadDatabase;
    BookParser bookParser;
    FileInputStream fileInputStream;
    BufferedReader bufferedReader;

    @BeforeEach
    void setup() throws FileNotFoundException {
        bookParser = new BookParser("\\|");
        dataBase = new DataBase();
        LoadDatabase loadDatabase = new LoadDatabase("C:\\Users\\user\\books-tons-of.txt", bookParser, dataBase);
        fileInputStream = new FileInputStream("C:\\Users\\user\\books-tons-of.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
    }

    @Test
    @Order(1)
    void Search_not_fount() throws IOException {
        String fildsLine = bufferedReader.readLine();

        while ((fildsLine = bufferedReader.readLine()) != null) {
            {
                String[] arrLine = fildsLine.split("\\|");

                for (int i = 0; i < arrLine.length; i++) {
                    arrLine[i]=arrLine[i].trim();
                }

                if (arrLine.length == 5) {
                    Book book = dataBase.BooksCatalog.get(arrLine[0]);
                    assertTrue(arrLine[0].equals(book.isbn));
                    assertTrue(dataBase.booksTitle.get(book.bookTitle).equals(arrLine[1]));
                    assertTrue(dataBase.authors.get(book.bookAuthor).equals(arrLine[2]));
                    assertEquals(arrLine[3], book.year);
                    assertTrue(dataBase.publishers.get(book.publisher).equals(arrLine[4]));
                }
            }

        }
    }
}
