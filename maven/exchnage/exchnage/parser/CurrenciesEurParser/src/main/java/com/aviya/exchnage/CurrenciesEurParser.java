package com.aviya.exchnage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;

public class CurrenciesEurParser implements Parser<CurrenciesData, Document> {
    private CurrenciesData currenciesData = new CurrenciesData();

    @Override
    public CurrenciesData parse(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("Cube");

        for (int i = 2; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            var value = getCurrency(element);
            currenciesData.add(value.currencyCode(), value);
        }
        return currenciesData;
    }

    private Currency getCurrency(Element element) {
        var currencyCode = element.getAttribute("currency");
        var rate = element.getAttribute("rate");
        return new Currency(currencyCode, new BigDecimal(rate));
    }
}
