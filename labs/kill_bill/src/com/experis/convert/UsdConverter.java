package com.experis.convert;

import com.experis.calcInvoice.Money;
import com.experis.currency.Currency;
import com.experis.currency.CurrencyConversionRate;

import java.math.BigDecimal;
import java.math.MathContext;

public class UsdConverter extends CurrencyConverter {
    Currency currency;

    public UsdConverter() {
        this.currency = CurrencyConversionRate.getCurrency("USD");
    }

    @Override
    public BigDecimal Convert(Money money, Currency currencyConvert) {
        BigDecimal value = currency.value();
        return money.getAmount().multiply(value).divide(currencyConvert.value(), MathContext.DECIMAL128);

    }
}
