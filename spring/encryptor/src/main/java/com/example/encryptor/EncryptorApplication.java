package com.example.encryptor;

import com.example.encryptor.messenger.Messenger;
import com.example.encryptor.transformation.TransformComposition;
import com.example.encryptor.transformation.UpperCase;
import com.example.encryptor.transformation.VowelReplacer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncryptorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EncryptorApplication.class, args);
    }

    @Autowired
    private Messenger messenger;


    @Override
    public void run(String... args) throws Exception {
        messenger.sendMessage();
    }
}
