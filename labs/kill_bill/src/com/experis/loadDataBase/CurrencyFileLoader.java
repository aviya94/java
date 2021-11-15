package com.experis.loadDataBase;

import com.experis.calcInvoice.Money;
import com.experis.currency.Currency;
import com.experis.currency.CurrencyConversionRate;
import com.experis.parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.HashMap;

public class CurrencyFileLoader extends Loader {
    private HashMap<String, Currency> currencies;


    public HashMap<String, Currency> getCurrencies() {
        return currencies;
    }

    public CurrencyFileLoader(Parser parser, String filePath) {
        super(parser, filePath);
        currencies = new HashMap<>();
        loadCurrencyFile(bufferedReader);
    }


    public void loadCurrencyFile(BufferedReader bufferedReader) {
        String currencyLine;
        try {
            while ((currencyLine = bufferedReader.readLine()) != null) {
                addToCurrencies(currencyLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToCurrencies(String currencyLine) {
        Currency currency = (Currency) parser.parse(currencyLine);
        currencies.put(currency.code(), currency);
        CurrencyConversionRate.addToList(currency.code(), currency);
    }

}