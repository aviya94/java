package com.experis.test;

import com.experis.Messanger;
import com.experis.Transformation.CaesarEncryption;
import com.experis.Transformation.UpperCase;
import com.experis.destanation.FileWriting;
import com.experis.sourse.FileReaders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.experis.sourse.FileReaders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessangerTest {
    FileReaders fileReaders;
    FileWriting fileWriting;

    @BeforeEach
    void setUp() {
        fileReaders = new FileReaders("C:\\Users\\user\\course\\java\\labs\\messenger\\classic\\src\\com\\experis\\resources\\Read.txt");
        fileWriting=new FileWriting("C:\\Users\\user\\course\\java\\labs\\messenger\\classic\\src\\com\\experis\\resources\\Writh.txt");
    }

    @Test
    void messanger() {
        Messanger messanger =new Messanger();
        messanger.sendMessage(fileReaders,new UpperCase(),new CaesarEncryption(),fileWriting);
    }
}


