package com.aviya.exchnage;
public interface Parser<T, U> {
    public T parse(U value);
}
