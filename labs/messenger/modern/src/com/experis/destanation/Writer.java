package com.experis.destanation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class Writer {

    public <T> void write(T massage, Consumer<T> write) {
        write.accept(massage);
    }



}
