package com.aviya.exchnage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.*;

class CurrenciesILParserTest {
    private static class Data{
        private static final String DATABASE= """
                <CURRENCIES>
                                   <LAST_UPDATE>2021-12-08</LAST_UPDATE>
                                   <CURRENCY>
                                   <NAME>Dollar</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>USD</CURRENCYCODE>
                                   <COUNTRY>USA</COUNTRY>
                                   <RATE>3.111</RATE>
                                   <CHANGE>-1.395</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Pound</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>GBP</CURRENCYCODE>
                                   <COUNTRY>Great Britain</COUNTRY>
                                   <RATE>4.1081</RATE>
                                   <CHANGE>-1.725</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Yen</NAME>
                                   <UNIT>100</UNIT>
                                   <CURRENCYCODE>JPY</CURRENCYCODE>
                                   <COUNTRY>Japan</COUNTRY>
                                   <RATE>2.7360</RATE>
                                   <CHANGE>-1.54</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Euro</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>EUR</CURRENCYCODE>
                                   <COUNTRY>EMU</COUNTRY>
                                   <RATE>3.5126</RATE>
                                   <CHANGE>-1.12</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Dollar</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>AUD</CURRENCYCODE>
                                   <COUNTRY>Australia</COUNTRY>
                                   <RATE>2.2185</RATE>
                                   <CHANGE>-0.893</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Dollar</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>CAD</CURRENCYCODE>
                                   <COUNTRY>Canada</COUNTRY>
                                   <RATE>2.4616</RATE>
                                   <CHANGE>-0.954</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>krone</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>DKK</CURRENCYCODE>
                                   <COUNTRY>Denmark</COUNTRY>
                                   <RATE>0.4724</RATE>
                                   <CHANGE>-1.109</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Krone</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>NOK</CURRENCYCODE>
                                   <COUNTRY>Norway</COUNTRY>
                                   <RATE>0.3473</RATE>
                                   <CHANGE>-0.344</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Rand</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>ZAR</CURRENCYCODE>
                                   <COUNTRY>South Africa</COUNTRY>
                                   <RATE>0.1970</RATE>
                                   <CHANGE>-0.354</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Krona</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>SEK</CURRENCYCODE>
                                   <COUNTRY>Sweden</COUNTRY>
                                   <RATE>0.3425</RATE>
                                   <CHANGE>-1.183</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Franc</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>CHF</CURRENCYCODE>
                                   <COUNTRY>Switzerland</COUNTRY>
                                   <RATE>3.3687</RATE>
                                   <CHANGE>-1.318</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Dinar</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>JOD</CURRENCYCODE>
                                   <COUNTRY>Jordan</COUNTRY>
                                   <RATE>4.3879</RATE>
                                   <CHANGE>-1.353</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Pound</NAME>
                                   <UNIT>10</UNIT>
                                   <CURRENCYCODE>LBP</CURRENCYCODE>
                                   <COUNTRY>Lebanon</COUNTRY>
                                   <RATE>0.0206</RATE>
                                   <CHANGE>-1.435</CHANGE>
                                   </CURRENCY>
                                   <CURRENCY>
                                   <NAME>Pound</NAME>
                                   <UNIT>1</UNIT>
                                   <CURRENCYCODE>EGP</CURRENCYCODE>
                                   <COUNTRY>Egypt</COUNTRY>
                                   <RATE>0.1976</RATE>
                                   <CHANGE>-1.397</CHANGE>
                                   </CURRENCY>
                                   </CURRENCIES>
                """;
    }

    private CurrenciesILParser currenciesILParser;

    @BeforeEach
    void setUp() {
        currenciesILParser =new CurrenciesILParser();
    }

    @Test
    void parse() throws ParserConfigurationException, IOException, SAXException {
        var doc= loadDataToDoc();
        var res= currenciesILParser.parse(doc);
        assertEquals(14,res.getSize());
        var excepted= new BigDecimal( 3.111);
        MathContext m = new MathContext(4);

        assertEquals(excepted.round(m),res.getCurrency("USD").rate());
    }

    private Document loadDataToDoc() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(Data.DATABASE));

        Document doc = db.parse(is);
        return doc;
    }
}