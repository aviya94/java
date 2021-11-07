package com.experis;

import com.experis.Transform.TransformComposition;
import com.experis.Transform.Transformation;
import com.experis.destanation.Writer;
import com.experis.sourse.Reader;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Massenger {
    private final Writer writer;
    private final Reader reader;
    private final Transformation transform;

    public Massenger(Writer writer, Reader reader, Transformation transform) {
        this.writer = writer;
        this.reader = reader;
        this.transform = transform;
    }

    public <T> void sendMessage(Supplier<T> readerSupplier, TransformComposition<T> TransformFunctions, Consumer<T> writerConsumer) {
        T message = reader.read(readerSupplier);
        TransformFunctions.applyComposition(message);
        writer.write(message, writerConsumer);

    }
}
