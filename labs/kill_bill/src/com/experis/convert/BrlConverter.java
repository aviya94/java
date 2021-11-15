package com.experis.convert;

import com.experis.calcInvoice.Money;
import com.experis.currency.Currency;
import com.experis.currency.CurrencyConversionRate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BrlConverter extends CurrencyConverter {
    Currency currency;

    public BrlConverter() {
        this.currency  = CurrencyConversionRate.getCurrency("BRL");
    }

    @Override
    public BigDecimal Convert(Money money, Currency currencyConvert) {
        BigDecimal value = currency.value();
        return  money.getAmount().multiply(value).divide(currencyConvert.value(),  MathContext.DECIMAL128);

    }
}
