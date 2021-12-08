import java.util.HashMap;
import java.util.HashSet;

public class CurrenciesData {
    private HashMap<String,Currency> currencies=new HashMap();

    public void add(String code, Currency currency){
        currencies.put(code,currency);
    }
    public Currency getCurrency(String code){
        return  currencies.get(code);
    }
}
