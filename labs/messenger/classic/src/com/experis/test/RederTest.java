package com.experis.test;

import com.experis.sourse.FileReaders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RederTest {
    FileReaders fileReaders;

    @BeforeEach
    void setUp() {
        fileReaders = new FileReaders("C:\\Users\\user\\course\\java\\labs\\messenger\\classic\\src\\com\\experis\\resources\\Read.txt");
    }

    @Test
    void writing_to_file() {
        String result =fileReaders.read();
assertEquals("hellow word!\nhellow word!",result);
    }
}
