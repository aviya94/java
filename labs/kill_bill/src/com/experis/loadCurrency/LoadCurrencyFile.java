package com.experis.loadCurrency;

import com.experis.loadCurrency.Currency;
import com.experis.parser.CurrencyParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoadCurrencyFile {
    private HashMap<String, Currency> currencies;
    private CurrencyParser currencyParser;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public HashMap<String, Currency> getCurrencies() {
        return currencies;
    }

    public LoadCurrencyFile(String filePath) {
        currencyParser = new CurrencyParser();
        currencies = new HashMap<>();

        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        Currency currency = currencyParser.parse(currencyLine);
        currencies.put(currency.currency(), currency);
    }

    public CurrenciesList getNewCurrenciesList() {
        return new CurrenciesList(currencies);
    }

    public void close() {
        try {
            if (fileReader != null) fileReader.close();
            if (bufferedReader != null) bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}