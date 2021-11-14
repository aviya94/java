package com.experis.convert;

import com.experis.TotalBill;
import com.experis.loadCurrency.CurrenciesList;

public class ChfConverter extends CurrencyConverter {

    @Override
    public void Convert(double price, int quantity, TotalBill totalBill, CurrenciesList currenciesList) {
        double value = currenciesList.getCurrencyValue("CHF");
        totalBill.addToBill(value * price * quantity);

    }
}
