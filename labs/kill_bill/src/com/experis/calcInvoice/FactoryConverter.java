package com.experis.calcInvoice;

import com.experis.convert.Converter;
import com.experis.currency.Currency;


import java.util.HashMap;

public class FactoryConverter {
    public HashMap<String, Converter> converters;

    public FactoryConverter(HashMap<String, Converter> converters) {
        this.converters = converters;
    }

    public Converter getConverter(Currency currency) {
        Converter value = converters.get(currency.code());

        if (value == null) {
            new IllegalArgumentException();
        }
        return value;
    }
}
