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
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CurrenciesEurParserTest {
    private static class Data{
        private static final String DATABASE= """
                <gesmes:Envelope xmlns:gesmes="http://www.gesmes.org/xml/2002-08-01" xmlns="http://www.ecb.int/vocabulary/2002-08-01/eurofxref">
                <gesmes:subject>Reference rates</gesmes:subject>
                <gesmes:Sender>
                <gesmes:name>European Central Bank</gesmes:name>
                </gesmes:Sender>
                <Cube>
                <Cube time="2021-12-08">
                <Cube currency="USD" rate="1.1299"/>
                <Cube currency="JPY" rate="128.57"/>
                <Cube currency="BGN" rate="1.9558"/>
                <Cube currency="CZK" rate="25.475"/>
                <Cube currency="DKK" rate="7.4362"/>
                <Cube currency="GBP" rate="0.85603"/>
                <Cube currency="HUF" rate="368.13"/>
                <Cube currency="PLN" rate="4.5962"/>
                <Cube currency="RON" rate="4.9488"/>
                <Cube currency="SEK" rate="10.2513"/>
                <Cube currency="CHF" rate="1.0432"/>
                <Cube currency="ISK" rate="147.40"/>
                <Cube currency="NOK" rate="10.0960"/>
                <Cube currency="HRK" rate="7.5250"/>
                <Cube currency="RUB" rate="83.3019"/>
                <Cube currency="TRY" rate="15.4796"/>
                <Cube currency="AUD" rate="1.5841"/>
                <Cube currency="BRL" rate="6.3350"/>
                <Cube currency="CAD" rate="1.4281"/>
                <Cube currency="CNY" rate="7.1726"/>
                <Cube currency="HKD" rate="8.8088"/>
                <Cube currency="IDR" rate="16205.54"/>
                <Cube currency="ILS" rate="3.5176"/>
                <Cube currency="INR" rate="85.2345"/>
                <Cube currency="KRW" rate="1328.25"/>
                <Cube currency="MXN" rate="23.6365"/>
                <Cube currency="MYR" rate="4.7733"/>
                <Cube currency="NZD" rate="1.6659"/>
                <Cube currency="PHP" rate="56.784"/>
                <Cube currency="SGD" rate="1.5415"/>
                <Cube currency="THB" rate="37.829"/>
                <Cube currency="ZAR" rate="17.8168"/>
                </Cube>
                </Cube>
                </gesmes:Envelope>
                """;
    }

private CurrenciesEurParser currenciesEurParser;

    @BeforeEach
    void setUp() {
        currenciesEurParser=new CurrenciesEurParser();
    }

    @Test
    void parse() throws ParserConfigurationException, IOException, SAXException {
        var doc= loadDataToDoc();
       var res= currenciesEurParser.parse(doc);
        assertEquals(32,res.getSize());
        var excepted= new BigDecimal( 1.1299);
        MathContext m = new MathContext(5);

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