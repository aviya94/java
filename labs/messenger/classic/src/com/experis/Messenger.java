package com.experis;

import com.experis.Transformation.TransformComposition;
import com.experis.destanation.writer;
import com.experis.sourse.Reader;

public class Messenger {
    public <T> void sendMessage(Reader<T> reader, TransformComposition<T> transformComposition, writer<T> writing) {
        T message = reader.read();

        while (message != null) {
            message = transformComposition.applyComposition(message);
            writing.write(message);
            message = reader.read();
        }
        writing.write(message);

    }
}
