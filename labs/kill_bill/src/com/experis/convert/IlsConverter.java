package com.experis.convert;

import com.experis.TotalBill;
import com.experis.loadCurrency.CurrenciesList;

public class IlsConverter extends CurrencyConverter{

    @Override
    public void Convert(double price, int quantity, TotalBill totalBill, CurrenciesList currenciesList) {
        double value = currenciesList.getCurrencyValue("ILS");
        totalBill.addToBill(value * price * quantity);
    }
}
