package com.experis.parser;

import com.experis.loadCurrency.Currency;

public class CurrencyParser implements Parser<Currency> {
    public Currency parse(String currency) {
        String[] value = currency.split("=");
        return new Currency(value[0], Double.valueOf(value[1]));
    }

}
