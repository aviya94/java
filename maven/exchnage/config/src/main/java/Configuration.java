import java.util.HashMap;

public class Configuration {
    private HashMap<String,Url> urls;

    public Configuration() {
        this.urls = new HashMap<>();
        urls.put("IL",new Url("https://www.boi.org.il/currency.xml","CURRENCY"));
        urls.put("EUR",new Url("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml","<Cube currency"));
    }
    public Url getUrl(String code){
        return  urls.get(code);
    }
}
