package com.experis.sourse;

import java.util.Scanner;
import java.util.function.Supplier;

public class Reader {

    public <T> T read(Supplier<T> read) {
        T massege = read.get();
        return massege;
    }

}
