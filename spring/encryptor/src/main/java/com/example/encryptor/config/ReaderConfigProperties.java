package com.example.encryptor.config;

import com.example.encryptor.destanation.ConsoleWriter;
import com.example.encryptor.destanation.Writer;
import com.example.encryptor.sourse.ConsoleReader;
import com.example.encryptor.sourse.Reader;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Setter
@Configuration
@ConfigurationProperties(prefix = "reader")
public class ReaderConfigProperties {
private String reader;

    public Reader<String> getReader() {
        switch (reader){
            case "console"->{return new ConsoleReader();}
        }
        return null;
    }

}
