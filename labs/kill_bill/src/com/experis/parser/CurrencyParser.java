package com.experis.parser;

import com.experis.currency.Currency;

import java.math.BigDecimal;

public class CurrencyParser implements Parser<Currency> {
    String delimited;
    public Currency parse(String currency) {
        String[] value = currency.split("=");
        return new Currency(BigDecimal.valueOf(Double.valueOf(value[1])),value[0]);
    }

}
