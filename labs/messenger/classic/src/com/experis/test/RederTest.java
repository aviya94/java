package com.experis.test;

import com.experis.sourse.FileReaderMassenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RederTest {
    private FileReaderMassenger fileReaders;

    @BeforeEach
    void setUp() {
        final var path = "./resources/Read.txt";
        fileReaders = new FileReaderMassenger(path);
    }

    @Test
    void writing_to_file() {
        final var expected = """
                Hello World!
                Love Java?
                """;
        StringBuilder sb = new StringBuilder();
        String result = fileReaders.read();

        while (result != null) {
            sb.append(result + "\n");
            result = fileReaders.read();
        }
        assertEquals(expected, String.valueOf(sb));
    }


}
