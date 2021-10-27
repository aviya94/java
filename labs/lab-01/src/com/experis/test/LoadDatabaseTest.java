package com.experis.test;
import com.experis.LoadDatabase;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoadDatabaseTest {

    LoadDatabase loadDatabase = new LoadDatabase("C:\\Users\\user\\books-tiny.txt");
    FileInputStream fstream;
    BufferedReader br;

    @BeforeEach
    void setup() throws FileNotFoundException {
        fstream = new FileInputStream("C:\\Users\\user\\books-tiny.txt");
        br = new BufferedReader(new InputStreamReader(fstream));
    }

    @Test
    @Order(1)
    void Books_catalog_ISBN() throws IOException {

        String strLine = br.readLine();

        while ((strLine = br.readLine()) != null) {

            String[] arrLine = strLine.split("\\|");
            String[] sameLineFromISBN = loadDatabase.getBooksCatalogISBN().get(arrLine[0]);
            assertEquals(arrLine[0], sameLineFromISBN[0]);
        }

    }

    @Test
    @Order(2)
    void Books_catalog_title() throws IOException {

        String strLine = br.readLine();

        while ((strLine = br.readLine()) != null) {

            String[] arrLine = strLine.split("\\|");
            String[] sameLineFromTitle = loadDatabase.getBooksCatalogTitel().get(arrLine[1]);
            assertEquals(arrLine[1], sameLineFromTitle[1]);
        }

    }

    @Test
    @Order(3)
    void authors() throws IOException {

        String strLine = br.readLine();

        while ((strLine = br.readLine()) != null) {

            String[] arrLine = strLine.split("\\|");
            int indexTitleAuthor = loadDatabase.getTiteFildlInHashMap().get("Book-Author");
            String author = arrLine[indexTitleAuthor];
            String[] sameLineFromISBN = loadDatabase.getBooksCatalogISBN().get(arrLine[0]);
            String valueAuthorISBN = loadDatabase.getAuthors().get(Integer.valueOf(sameLineFromISBN[indexTitleAuthor]));
            assertEquals(author, valueAuthorISBN);
        }
    }

    @Test
    @Order(4)
    void publishers() throws IOException {

        String strLine = br.readLine();

        while ((strLine = br.readLine()) != null) {

            String[] arrLine = strLine.split("\\|");
            int indexTitlePublisher = loadDatabase.getTiteFildlInHashMap().get("Publisher");
            String author = arrLine[indexTitlePublisher];
            String[] sameLineFromISBN = loadDatabase.getBooksCatalogISBN().get(arrLine[0]);
            String valueAuthorISBN = loadDatabase.getPublishers().get(Integer.valueOf(sameLineFromISBN[indexTitlePublisher]));
            assertEquals(author, valueAuthorISBN);
        }
    }

    @Test
    @Order(5)
    void titel_filds() throws IOException {

        String strLine = br.readLine();
        String[] arrLine = strLine.split("\\|");

        for (int i = 0; i < arrLine.length; i++) {
            assertEquals(i, loadDatabase.getTiteFildlInHashMap().get(arrLine[i]));
        }
    }

}
