package com.experis.tests;

import com.experis.currency.Currency;
import com.experis.loadDataBase.CurrencyFileLoader;

import java.math.BigDecimal;
import java.util.HashMap;

import com.experis.parser.CurrencyParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyFileLoaderTest {
    CurrencyFileLoader loadCurrencyFile;

    @BeforeEach
    void setUp() {
        CurrencyParser currencyParser=new CurrencyParser();
        loadCurrencyFile = new CurrencyFileLoader(currencyParser,"./resources/RatesFile.txt");

    }

    @AfterEach
    void afterEach() {
        loadCurrencyFile.close();
    }

    @Test
    void load_Currency_File() {
        HashMap<String, Currency> currencies = new HashMap<>();
        currencies.put("CHF", new Currency(BigDecimal.valueOf(0.82),"CHF" ));
        currencies.put("USD", new Currency(BigDecimal.valueOf(0.73),"USD"));
        currencies.put("ILS", new Currency(BigDecimal.valueOf(0.21),"ILS"));
        currencies.put("BRL", new Currency( BigDecimal.valueOf(0.31),"BRL"));
        assertEquals(currencies, loadCurrencyFile.getCurrencies());

    }
}