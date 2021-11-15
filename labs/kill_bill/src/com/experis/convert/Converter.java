package com.experis.convert;

import com.experis.calcInvoice.Money;
import com.experis.currency.Currency;

import java.math.BigDecimal;

public interface Converter {
    public BigDecimal Convert(Money money, Currency currencyConvert);

}
