package com.aviya.exchnage;
import org.w3c.dom.Document;

import java.math.BigDecimal;


public class Manager {
    private Configuration configuration = new Configuration();
    private ParserFactory parserFactory = new ParserFactory();
    private CurrenciesData currenciesData = new CurrenciesData();
    private Exchanger currencyConverter = new Exchanger();

    public Manager(String code) {
        loadData(code);
    }

    private CurrenciesData loadData(String code) {
        var url = configuration.getUrl(code);
        Document doc = UrlLoader.load(url);
        Parser parser = parserFactory.getParser(code);
        currenciesData= (CurrenciesData) parser.parse(doc);
        return currenciesData;
    }

    public BigDecimal convert(String from, String to, BigDecimal amount) {
        return currencyConverter.Convert(currenciesData.getCurrency(from),
                currenciesData.getCurrency(to), amount);
    }
}
