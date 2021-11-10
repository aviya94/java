package com.experis.comput.factory;

import com.experis.comput.Computable;

public interface FactoryOperand<T> {
    void addToTokenValue(T val);
    Computable create(String op);

}
