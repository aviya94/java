package com.experis.convert;

import com.experis.TotalBill;
import com.experis.loadCurrency.CurrenciesList;

public interface Converter {
    public void Convert(double price, int quantity, TotalBill totalBill, CurrenciesList currenciesList);

}
