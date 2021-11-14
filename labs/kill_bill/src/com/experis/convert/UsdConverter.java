package com.experis.convert;

import com.experis.TotalBill;
import com.experis.loadCurrency.CurrenciesList;

public class UsdConverter extends CurrencyConverter {

    @Override
    public void Convert(double price, int quantity, TotalBill totalBill, CurrenciesList currenciesList) {
        double value = currenciesList.getCurrencyValue("USD");
        totalBill.addToBill(value * price * quantity);

    }
}
