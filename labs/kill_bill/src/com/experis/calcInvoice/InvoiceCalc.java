package com.experis.calcInvoice;

import com.experis.currency.Currency;
import com.experis.currency.CurrencyConversionRate;

import java.math.BigDecimal;

public class InvoiceCalc {
    private Invoice invoice;
    private ItemCalc itemCalc = new ItemCalc();
    private BigDecimal bill = new BigDecimal(0);
    private FactoryConverter factoryConverter;
    Currency currencyConvert;

    public InvoiceCalc(Invoice invoice, FactoryConverter factoryConverter, String currencyConvert) {
        this.invoice = invoice;
        this.factoryConverter = factoryConverter;
        this.currencyConvert = CurrencyConversionRate.getCurrency(currencyConvert);
        billCalc();
    }

    public void addItem(Item item) {
        invoice.addItem(item);
    }

    public void billCalc() {
        for (Item e : invoice.getItems()) {
           bill= bill.add(itemCalc.calc(factoryConverter.getConverter(e.money().getCurrency()), e.quantity(), e.money(), currencyConvert));
        }
    }

    public BigDecimal getBill() {
        return bill;
    }
}
