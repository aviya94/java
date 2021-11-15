package com.experis.currency;

import com.experis.calcInvoice.Money;

import java.util.HashMap;

public abstract class CurrencyConversionRate {
    private static HashMap<String, Currency> currencies = new HashMap<>();


    public static Currency getCurrency(String currency) {
        Currency value = currencies.get(currency);
        if (value == null) {
            new IllegalArgumentException();
        }
        return value;
    }

    public static void addToList(String code, Currency currency) {
        currencies.put(code, currency);
    }
}
