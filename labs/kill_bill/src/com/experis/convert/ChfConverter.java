package com.experis.convert;

import com.experis.calcInvoice.Money;
import com.experis.currency.Currency;
import com.experis.currency.CurrencyConversionRate;

import java.math.BigDecimal;
import java.math.MathContext;

public class ChfConverter extends CurrencyConverter {
    Currency currency;

    public ChfConverter() {
        this.currency = CurrencyConversionRate.getCurrency("CHF");
    }

    @Override
    public BigDecimal Convert(Money money, Currency currencyConvert) {
        BigDecimal value = currency.value();
        return money.getAmount().multiply(value).divide(currencyConvert.value(), MathContext.DECIMAL128);

    }
}
