package com.experis.calcInvoice;

import com.experis.currency.Currency;

import java.math.BigDecimal;


public class Money {
    private Currency currency;
    private BigDecimal amount;

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Money(Currency currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money(Currency currency, long amount) {
        this.currency = currency;
        this.amount = new BigDecimal(amount);
    }

    public Money multiply(int quantity) {
        var q = new BigDecimal(quantity);
        var a = amount.multiply(q);
        return new Money(currency, a);
    }
}
