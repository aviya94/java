package com.experis.parser;

import com.experis.calcInvoice.Item;
import com.experis.calcInvoice.Money;
import com.experis.currency.Currency;
import com.experis.currency.CurrencyConversionRate;

import java.math.BigDecimal;

public class TxtParser extends ItemParser{

    public TxtParser(String delimited) {
        super(delimited);
    }

    @Override
    public Item parse(String value) {
        String[] valueArr = value.split(delimited);

        Currency currency=CurrencyConversionRate.getCurrency(valueArr[3]);
        return new Item(valueArr[0], Integer.valueOf(valueArr[1]),new Money(currency,Long.valueOf(valueArr[2])));
    }
}
