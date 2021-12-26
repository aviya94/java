package com.example.encryptor.config;


import com.example.encryptor.destanation.ConsoleWriter;
import com.example.encryptor.destanation.Writer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Setter
@Configuration
@ConfigurationProperties(prefix = "writer")
public class WriterConfigProperties {

    private String writer;

    public Writer<String> getWriter() {
        switch (writer){
            case "console"->{return new ConsoleWriter();}
        }
        return null;
    }


}
