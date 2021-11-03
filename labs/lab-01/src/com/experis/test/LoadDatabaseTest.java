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
    BufferedReader bufferedReader;

    @BeforeEach
    void setup() {
        bookParser = new BookParser("\\|");
        dataBase = new DataBase();
        LoadDatabase loadDatabase = new LoadDatabase("C:\\Users\\user\\books-tons-of.txt", bookParser, dataBase);
    }

    @Test
    @Order(1)
    void load_databse() {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\user\\books-tons-of.txt")) {
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String fildsLine = bufferedReader.readLine();

            while ((fildsLine = bufferedReader.readLine()) != null) {
                {
                    String[] arrLine = fildsLine.split("\\|");

                    for (int i = 0; i < arrLine.length; i++) {
                        arrLine[i] = arrLine[i].trim();
                    }
                    if (arrLine.length == 5) {

                        Book book = dataBase.BooksCatalog.get(arrLine[0]);
                        assertTrue(arrLine[0].equals(book.isbn));

                        int resultIndex = dataBase.getIndex(dataBase.booksTitle, book.bookTitle);
                        String resultTitle = dataBase.booksTitle.get(resultIndex).toString();
                        resultTitle = resultTitle.trim();
                        assertTrue(resultTitle.equals(arrLine[1]));

                        resultIndex = dataBase.getIndex(dataBase.authors, book.bookAuthor);
                        String resultAuthor = dataBase.authors.get(resultIndex).toString();
                        resultAuthor = resultAuthor.trim();
                        assertTrue(resultAuthor.equals(arrLine[2]));

                        assertEquals(arrLine[3], book.year);

                        resultIndex = dataBase.getIndex(dataBase.publishers, book.publisher);
                        String resultPublisher = dataBase.publishers.get(resultIndex).toString();
                        resultPublisher = resultPublisher.trim();
                        assertTrue(resultPublisher.equals(arrLine[4]));
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
