package com.experis.loadCurrency;

import com.experis.loadCurrency.Currency;

import java.util.HashMap;

public class CurrenciesList {
    private HashMap<String, Currency> currencies;

    public CurrenciesList(HashMap<String, Currency> currencies) {
        this.currencies = currencies;
    }

    public Double getCurrencyValue(String currency) {
        Currency value = currencies.get(currency);
        if (value == null) {
            new IllegalArgumentException();
        }
        return value.value();
    }
}
