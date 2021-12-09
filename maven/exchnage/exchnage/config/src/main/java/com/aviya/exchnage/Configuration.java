package com.aviya.exchnage;

import java.util.HashMap;
import java.util.HashSet;


public class Configuration {
    private HashMap<String,String> urls;

    public Configuration() {
        this.urls = new HashMap<>();
        urls.put("IL","https://www.boi.org.il/currency.xml");
        urls.put("EUR","https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
    }
    public String getUrl(String code){
        return  urls.get(code);
    }
}
