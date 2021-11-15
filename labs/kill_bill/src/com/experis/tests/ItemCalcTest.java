package com.experis.tests;

import com.experis.calcInvoice.ItemCalc;
import com.experis.calcInvoice.Money;
import com.experis.convert.*;
import com.experis.currency.Currency;
import com.experis.loadDataBase.CurrencyFileLoader;
import com.experis.parser.CurrencyParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemCalcTest {
    ItemCalc itemCalc;


    @BeforeEach
    void setUp() {
        CurrencyParser currencyParser = new CurrencyParser();
        CurrencyFileLoader loadCurrencyFile = new CurrencyFileLoader(currencyParser, "./resources/RatesFile.txt");
        itemCalc = new ItemCalc();

    }

    @Test
    void calc() {
        Converter converter = new UsdConverter();
        int quantity = 10;
        Currency currency = new Currency(new BigDecimal(0.73), "USD");
        BigDecimal unitPrice = new BigDecimal(3.12);
        Money money = new Money(currency, unitPrice);
        BigDecimal value = new BigDecimal(0.73);
        Currency usd = new Currency(value, "USD");
        BigDecimal result = itemCalc.calc(converter, quantity, money, usd);
        Double excepted = 31.200000000000003;
        ;
        assertEquals(excepted, result.doubleValue());
    }


}