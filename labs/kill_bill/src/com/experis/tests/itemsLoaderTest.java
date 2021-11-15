package com.experis.tests;

import com.experis.calcInvoice.*;
import com.experis.convert.*;
import com.experis.currency.Currency;
import com.experis.loadDataBase.CurrencyFileLoader;
import com.experis.loadDataBase.ItemsLoader;
import com.experis.parser.CurrencyParser;
import com.experis.parser.RecParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class itemsLoaderTest {
    ItemsLoader itemsLoader;
    Invoice invoice;
    InvoiceCalc invoiceCalc;
    HashMap<String, Converter> converters;
    @BeforeEach
    void setUp() {
        CurrencyParser currencyParser=new CurrencyParser();
        CurrencyFileLoader loadCurrencyFile = new CurrencyFileLoader(currencyParser,"./resources/RatesFile.txt");
        ArrayList<Item> items = new ArrayList<>();
        Currency brl=new Currency(new BigDecimal(3.12),"BRL");
        Currency usd=new Currency(new BigDecimal(4.25),"USD");
        Currency crf=new Currency(new BigDecimal(8.99),"CRF");

        Money brlMoney=new Money(brl,new BigDecimal(3.12));
        Money usdMoney=new Money(usd,new BigDecimal(4.25));
        Money crfMoney=new Money(crf,new BigDecimal(8.99));

        items.add(new Item("Ice cubes bag", 10,brlMoney));
        items.add(new Item("drizzle", 14, usdMoney));
        items.add(new Item("slush", 3, crfMoney));


         converters = new HashMap();
        converters.put("USD", new UsdConverter());
        converters.put("BRL", new BrlConverter());
        converters.put("CHF", new ChfConverter());
        converters.put("ILS", new IlsConverter());
        FactoryConverter factoryConverter=new FactoryConverter(converters);
        invoice = new Invoice(items);
        invoiceCalc = new InvoiceCalc(invoice, factoryConverter, "USD");



        RecParser recParser = new RecParser("~~", " ");
        itemsLoader = new ItemsLoader(recParser, "./resources/RatesFile.txt", invoice);
    }

    @Test
    void loadItem() {
    }


}