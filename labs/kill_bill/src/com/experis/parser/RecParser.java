package com.experis.parser;

import com.experis.calcInvoice.Item;
import com.experis.calcInvoice.Money;
import com.experis.currency.Currency;
import com.experis.currency.CurrencyConversionRate;

public class RecParser extends ItemParser {
    private String currencyDelimiter;

    public RecParser(String delimited, String currencyDelimiter) {
        super(delimited);
        this.currencyDelimiter = currencyDelimiter;
    }

    @Override
    public Item parse(String value) {
        String[] valueArr = value.split(delimited);
        String[] currencyArr = valueArr[2].split(currencyDelimiter);
        Currency currency= CurrencyConversionRate.getCurrency(currencyArr[1]);
        Money money=new Money(currency ,Long.valueOf(currencyArr[0]));
        return new Item(valueArr[1], Integer.valueOf(valueArr[0]),money);
    }
}
