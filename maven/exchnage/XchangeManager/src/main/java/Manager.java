import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;


public class Manager {
    private Configuration configuration = new Configuration();
    private ParserFactory parserFactory = new ParserFactory();
    private CurrenciesData currenciesData = new CurrenciesData();
    private CurrencyConverter currencyConverter = new CurrencyConverter();

    public Manager(String code) {
        loadData(code);
    }

    private CurrenciesData loadData(String code) {
        var url = configuration.getUrl(code);
        Document doc = UrlLoader.load(url.url());
        NodeList nodeList = doc.getElementsByTagName(url.XmlElementName());
        Parser parser = parserFactory.getParser(code);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Currency value = (Currency) parser.parse(element);
            currenciesData.add(value.currencyCode(), value);
        }
        return currenciesData;
    }

    public BigDecimal convert(String from, String to, BigDecimal amount) {
        return currencyConverter.Convert(currenciesData.getCurrency(from),
                currenciesData.getCurrency(to), amount);
    }
}
