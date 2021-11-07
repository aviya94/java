package com.experis.test;

import com.experis.Transformation.Censor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CensorTest {
    private Censor censor;

    @BeforeEach
    void setUp() {
        ArrayList<String> censorList = new ArrayList<>();
        censorList.add("word");
        censorList.add("hi");
        censorList.add("bye");
        censor = new Censor(censorList);
    }

    @Test
    void censor() {
        String message = "helow word hi bye";
        String result = "helow **** ** ***";
        assertEquals(result, censor.transforn(message));
    }

}
