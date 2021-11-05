package com.experis;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Massenger {
    private Writer writer;
    private Reader reader;
    private Transformation transform;

    public Massenger(Writer writer, Reader reader, Transformation transform) {
        this.writer = writer;
        this.reader = reader;
        this.transform = transform;
    }

    public <T> void sendMessage(Supplier<T> readerSupplier, Function<T, T> firstTransformFunction, Function<T, T> secondTransformFunction, Consumer<T> writerConsumer) {
        T message = reader.read(readerSupplier);
        message = (T) transform.transform(firstTransformFunction, message);
        message = (T) transform.transform(secondTransformFunction, message);
        writer.write(message, writerConsumer);

    }
}
