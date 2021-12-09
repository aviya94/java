package com.aviya.exchnage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;


public class CurrenciesILParser implements Parser<CurrenciesData, Document> {
    private CurrenciesData currenciesData = new CurrenciesData();

    @Override
    public CurrenciesData parse(Document doc) {

        NodeList nodeList = doc.getElementsByTagName("CURRENCY");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Currency value = getCurrency(element);
            currenciesData.add(value.currencyCode(), value);
        }
        return currenciesData;
    }

    private Currency getCurrency(Element doc) {
        String currencyCode = doc.getElementsByTagName("CURRENCYCODE").item(0).getTextContent();
        String rate = doc.getElementsByTagName("RATE").item(0).getTextContent();
        return new Currency(currencyCode, new BigDecimal(rate));
    }

}
