package com.experis.Parser;

import com.experis.token.Token;
import com.experis.token.TokenValue;

import java.util.ArrayList;
import java.util.Hashtable;

public class TokenParser implements Parser<Hashtable<Token, String>> {
    String buffer;
    Hashtable<Token, String> parse = new Hashtable<>();

    public TokenParser(String buffer) {
        this.buffer = buffer;
    }

    @Override
    public Hashtable<Token, String> Parser(String val) {
        String[] arrayPrefix = val.split(buffer);
        return convertToToken(arrayPrefix);

    }

    Hashtable<Token, String> convertToToken(String[] arrayPrefix) {
        for (String e : arrayPrefix) {
            TokenValue.getToken(e);
            parse.put(TokenValue.getToken(e), e);
        }
        return parse;
    }

}
