package com.experis.test;

import com.experis.Transformation.CaesarEncryption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaesarEncryptionTest {
    private CaesarEncryption caesarEncryption;

    @BeforeEach
    void setUp() {
        caesarEncryption = new CaesarEncryption();
    }

    @Test
    void Caesar_ncryption_lower() {
        String message = "helow word";
        String result = "urybj jbeq";
        assertEquals(result, caesarEncryption.transforn(message));
    }

    @Test
    void Caesar_ncryption_upper() {
        String message = "HELOW WORD";
        String resulr = "URYBJ JBEQ";
        assertEquals(resulr, caesarEncryption.transforn(message));
    }
}
