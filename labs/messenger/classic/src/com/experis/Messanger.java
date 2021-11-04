package com.experis;

import com.experis.Transformation.Transform;
import com.experis.destanation.Writing;
import com.experis.sourse.Reader;

public class Messanger {
    public <T> void sendMessage(Reader<T> reader, Transform<T>transform1, Transform<T>transform2, Writing<T> writing){
        T message= reader.read();
        message= (T) transform1.transforn(message);
        message=(T) transform2.transforn(message);
        writing.writh(message);

    }
}
