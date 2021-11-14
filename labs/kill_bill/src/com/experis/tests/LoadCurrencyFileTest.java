package com.experis.tests;

import com.experis.loadCurrency.Currency;
import com.experis.loadCurrency.LoadCurrencyFile;


import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadCurrencyFileTest {
    LoadCurrencyFile loadCurrencyFile;

    @BeforeEach
    void setUp() {
        final var path = "./resources/InputFile.txt";
        loadCurrencyFile = new LoadCurrencyFile(path);
    }

    @AfterEach
    void afterEach() {
        loadCurrencyFile.close();
    }

    @Test
    void load_Currency_File() {
        HashMap<String, Currency> currencies = new HashMap<>();
        currencies.put("CHF", new Currency("CHF", 0.82));
        currencies.put("USD", new Currency("USD", 0.73));
        currencies.put("ILS", new Currency("ILS", 0.21));
        currencies.put("BRL", new Currency("BRL", 0.31));
        assertEquals(currencies, loadCurrencyFile.getCurrencies());

    }
}