package com.experis.test;
import com.experis.Transformation.CaesarEncryption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaesarEncryptionTest {
    CaesarEncryption caesarEncryption = new CaesarEncryption();
    @BeforeEach
    void setUp() {

        //fileWriting = new FileWriting("Writh.txt");
    }

    @Test
    void Caesar_ncryption_lower() {
        String message = "helow word";
        String resulr = "urybj jbeq";
        assertEquals(resulr, caesarEncryption.transforn(message));
    }
    @Test
    void Caesar_ncryption_upper() {
        String message = "HELOW WORD";
        String resulr = "URYBJ JBEQ";
        assertEquals(resulr, caesarEncryption.transforn(message));
    }
}
