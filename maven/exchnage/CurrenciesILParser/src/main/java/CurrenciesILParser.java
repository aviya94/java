import org.w3c.dom.Element;

import java.math.BigDecimal;


public class CurrenciesILParser implements Parser<Currency, Element> {
    @Override
    public Currency parse(Element doc) {

        String currencyCode = doc.getElementsByTagName("CURRENCYCODE").item(0).getTextContent();
        String rate = doc.getElementsByTagName("RATE").item(0).getTextContent();
        System.out.println(currencyCode+rate);
        return new Currency(currencyCode, new BigDecimal(rate));
    }

}
