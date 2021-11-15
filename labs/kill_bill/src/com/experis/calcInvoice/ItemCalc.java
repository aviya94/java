package com.experis.calcInvoice;

import com.experis.convert.Converter;
import com.experis.currency.Currency;

import java.math.BigDecimal;

public class ItemCalc {

    public BigDecimal calc(Converter converter, int quantity, Money money, Currency currencyConvert) {
        return converter.Convert(money.multiply(quantity), currencyConvert);
    }
}

