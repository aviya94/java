package com.aviya.exchnage;
import java.util.HashMap;

public class ParserFactory {

    private HashMap<String, Parser> CurrencyParser;

    public ParserFactory() {
        CurrencyParser = new HashMap<>();
        CurrencyParser.put("IL", new CurrenciesILParser());
        CurrencyParser.put("EUR", new CurrenciesEurParser());
    }

    public com.aviya.exchnage.Parser getParser(String code) {
        return CurrencyParser.get(code);
    }
}
