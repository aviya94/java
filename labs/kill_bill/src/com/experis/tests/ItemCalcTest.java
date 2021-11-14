package com.experis.tests;

import com.experis.Item;
import com.experis.ItemCalc;
import com.experis.TotalBill;
import com.experis.convert.*;
import com.experis.loadCurrency.LoadCurrencyFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ItemCalcTest {
    ItemCalc itemCalc;
    TotalBill totalBill;

    @BeforeEach
    void setUp() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Ice cubes bag", 10, 3.12, "BRL"));
        items.add(new Item("drizzle", 14, 4.25, "USD"));
        items.add(new Item("slush", 3, 8.99, "CHF"));
        HashMap<String, Converter> converters = new HashMap();
        converters.put("USD", new UsdConverter());
        converters.put("BRL", new BrlConverter());
        converters.put("CHF", new ChfConverter());
        converters.put("ILS", new IlsConverter());
        totalBill = new TotalBill();
        LoadCurrencyFile loadCurrencyFile = new LoadCurrencyFile("./resources/InputFile.txt");
        itemCalc = new ItemCalc(items, converters, totalBill, loadCurrencyFile.getNewCurrenciesList());

    }

    @Test
    void calc() {
        itemCalc.calc();
        double excepted = 75.2224;
        assertEquals(excepted, totalBill.getBill());
    }


}