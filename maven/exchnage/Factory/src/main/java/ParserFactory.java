import java.util.HashMap;

public class ParserFactory {

    private HashMap<String, Parser> CurrencyParser;

    public ParserFactory() {
        CurrencyParser = new HashMap<>();
        CurrencyParser.put("IL", new CurrenciesILParser());
        //CurrencyParser.put("EUR", new CurrenciesEurParser());
    }

    public Parser getParser(String code) {
        return CurrencyParser.get(code);
    }
}
