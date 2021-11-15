package com.experis.tests;

import com.experis.calcInvoice.Money;
import com.experis.convert.*;
import com.experis.currency.Currency;
import com.experis.loadDataBase.CurrencyFileLoader;
import com.experis.parser.CurrencyParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ConvertTest {
    CurrencyFileLoader loadCurrencyFile;

    @BeforeEach

    void setUp() {
        CurrencyParser currencyParser=new CurrencyParser();
        CurrencyFileLoader loadCurrencyFile = new CurrencyFileLoader(currencyParser,"./resources/RatesFile.txt");

    }

    @Test
    void brl() {
        BrlConverter brlConverter = new BrlConverter();
        BigDecimal bigDecimalUsd=new BigDecimal(0.73);
        BigDecimal bigDecimalBrl=new BigDecimal(0.31);
        Currency usd=new Currency(bigDecimalUsd,"USD");
        Currency brl=new Currency(bigDecimalBrl,"BRL");
        BigDecimal bigDecimalOne=new BigDecimal(1);
        Money money=new Money(brl,bigDecimalOne);
        var value= brlConverter.Convert(money,usd);
        double excepted = 0.4246575342465754;
        assertEquals(excepted,value.doubleValue() );
    }

    @Test
    void usd() {
        UsdConverter usdConverter = new UsdConverter();
        BigDecimal bigDecimalUsd=new BigDecimal(0.73);
        BigDecimal bigDecimalChf=new BigDecimal(0.82);
        Currency usd=new Currency(bigDecimalUsd,"USD");
        Currency chf=new Currency(bigDecimalChf,"CHF");
        BigDecimal bigDecimalOne=new BigDecimal(1);
        Money money=new Money(usd,bigDecimalOne);
        var value= usdConverter.Convert(money,chf);
        double excepted = 0.8902439024390244;
        assertEquals(excepted, value.doubleValue());
    }

    @Test
    void chf() {
        ChfConverter chfConverter = new ChfConverter();
        BigDecimal bigDecimalUsd=new BigDecimal(0.73);
        BigDecimal bigDecimalChf=new BigDecimal(0.82);
        Currency usd=new Currency(bigDecimalUsd,"USD");
        Currency chf=new Currency(bigDecimalChf,"CHF");
        BigDecimal bigDecimalOne=new BigDecimal(1);
        Money money=new Money(chf,bigDecimalOne);
        var value= chfConverter.Convert(money,usd);
        double excepted = 1.1232876712328768;
        assertEquals(excepted, value.doubleValue());
    }

    @Test
    void ils() {
        IlsConverter ilsConverter = new IlsConverter();
        BigDecimal bigDecimalUsd=new BigDecimal(0.73);
        BigDecimal bigDecimalIls=new BigDecimal(0.21);
        Currency usd=new Currency(bigDecimalUsd,"USD");
        Currency chf=new Currency(bigDecimalIls,"ILS");
        BigDecimal bigDecimalOne=new BigDecimal(1);
        Money money=new Money(chf,bigDecimalOne);
        var value= ilsConverter.Convert(money,usd);
        double excepted = 0.2876712328767123;
        assertEquals(excepted, value.doubleValue());
    }

}
