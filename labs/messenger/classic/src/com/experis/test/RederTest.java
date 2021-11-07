package com.experis.test;

import com.experis.sourse.FileReaders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RederTest {
    FileReaders fileReaders;

    @BeforeEach
    void setUp() {
        final var path = "./src/com/experis/resources/Read.txt";
        fileReaders = new FileReaders(path);
    }

    @Test
    void writing_to_file() {
        final var expected = """
                Hello World!
                Love Java?
                """;

        String result = fileReaders.read();
        assertEquals(expected, result);
    }


}
