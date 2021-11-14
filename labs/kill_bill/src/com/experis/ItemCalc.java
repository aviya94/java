package com.experis;

import com.experis.convert.Converter;
import com.experis.loadCurrency.CurrenciesList;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCalc {
    private HashMap<String, Converter> converter;
    private ArrayList<Item> items;
    private TotalBill totalBill;
    CurrenciesList currenciesList;

    public ItemCalc(ArrayList<Item> items, HashMap<String, Converter> converters,
                    TotalBill totalBill, CurrenciesList currenciesList) {
        this.converter = converters;
        this.items = items;
        this.totalBill = totalBill;
        this.currenciesList = currenciesList;
    }

    public void calc() {
        for (Item e : items) {
            Converter currency = converter.get(e.currency());
            currency.Convert(e.unitPrice(), e.quantity(), totalBill, currenciesList);
        }
    }

}
