package com.experis.tests;
import com.experis.calcInvoice.*;
import com.experis.currency.Currency;
import com.experis.convert.*;
import com.experis.loadDataBase.CurrencyFileLoader;
import com.experis.parser.CurrencyParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {
    Invoice invoice;
    FactoryConverter factoryConverter;
    CurrencyFileLoader loadCurrencyFile;
    InvoiceCalc invoiceCalc;

    @BeforeEach
    void setUp() {
        CurrencyParser currencyParser = new CurrencyParser();
        CurrencyFileLoader loadCurrencyFile = new CurrencyFileLoader(currencyParser, "./resources/RatesFile.txt");
        ArrayList<Item> items = new ArrayList<>();
        Currency brl=new Currency(new BigDecimal(3.12),"BRL");
        Currency usd=new Currency(new BigDecimal(4.25),"USD");
        Currency crf=new Currency(new BigDecimal(8.99),"CHF");

        Money brlMoney=new Money(brl,new BigDecimal(3.12));
        Money usdMoney=new Money(usd,new BigDecimal(4.25));
        Money crfMoney=new Money(crf,new BigDecimal(8.99));

        items.add(new Item("Ice cubes bag", 10,brlMoney));
        items.add(new Item("drizzle", 14, usdMoney));
        items.add(new Item("slush", 3, crfMoney));


        HashMap<String, Converter> converters = new HashMap();
        converters.put("USD", new UsdConverter());
        converters.put("BRL", new BrlConverter());
        converters.put("CHF", new ChfConverter());
        converters.put("ILS", new IlsConverter());
        factoryConverter = new FactoryConverter(converters);
        invoice = new Invoice(items);
        invoiceCalc = new InvoiceCalc(invoice, factoryConverter, "USD");


    }

    @Test
    void invoice() {
        assertEquals(103.04438356164384, invoiceCalc.getBill().doubleValue());
    }


}