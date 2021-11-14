package com.experis.tests;

import com.experis.Item;
import com.experis.TotalBill;
import com.experis.convert.*;
import com.experis.loadCurrency.LoadCurrencyFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ConvertTest {
    TotalBill totalBill;
    LoadCurrencyFile loadCurrencyFile;

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
        loadCurrencyFile = new LoadCurrencyFile("./resources/InputFile.txt");

    }

    @Test
    void brl() {
        BrlConverter brlConverter = new BrlConverter();
        brlConverter.Convert(1, 1, totalBill, loadCurrencyFile.getNewCurrenciesList());
        double brl = 0.31;
        assertEquals(brl, totalBill.getBill());
    }

    @Test
    void usd() {
        UsdConverter usdConverter = new UsdConverter();
        usdConverter.Convert(1, 1, totalBill, loadCurrencyFile.getNewCurrenciesList());
        double usd = 0.73;
        assertEquals(usd, totalBill.getBill());
    }

    @Test
    void chf() {
        ChfConverter chfConverter = new ChfConverter();
        chfConverter.Convert(1, 1, totalBill, loadCurrencyFile.getNewCurrenciesList());
        double chf = 0.82;
        assertEquals(chf, totalBill.getBill());
    }

    @Test
    void ils() {
        IlsConverter ilsConverter = new IlsConverter();
        ilsConverter.Convert(1, 1, totalBill, loadCurrencyFile.getNewCurrenciesList());
        double ils = 0.21;
        assertEquals(ils, totalBill.getBill());
    }

}
