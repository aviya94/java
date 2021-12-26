package com.example.encryptor.messenger;

import com.example.encryptor.config.ReaderConfigProperties;
import com.example.encryptor.config.WriterConfigProperties;
import com.example.encryptor.destanation.Writer;
import com.example.encryptor.sourse.Reader;
import com.example.encryptor.transformation.TransformComposition;
import org.springframework.stereotype.Component;

@Component
public class Messenger<T>{

   private final Reader<T> reader;
   private final TransformComposition<T> transformComposition;
   private final Writer<T> writer;

    public Messenger(TransformComposition<T> transformComposition, ReaderConfigProperties reader, WriterConfigProperties writer) {
       this.reader = (Reader<T>) reader.getReader();
        this.transformComposition = transformComposition;
        this.writer = (Writer<T>) writer.getWriter();
    }


    public void sendMessage() {

        T message = reader.read();

        while (message != null) {
            message = transformComposition.applyComposition(message);
            writer.write(message);
            message = reader.read();
        }
        writer.write(message);

    }


}
