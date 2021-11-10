package com.experis.token;

import com.experis.comput.Computable;

import java.util.Hashtable;
import java.util.function.Function;

public abstract class TokenValue {
    private final static Hashtable<String, Token> TOKEN_VALUE = new Hashtable<>();
    private final static Hashtable<Token, Function<String, Computable>> TOKEN_FACTORY = new Hashtable<>();
    public static void add(String value, Token token) {
        if (TOKEN_VALUE.get(value) == null) {
            TOKEN_VALUE.put(value, token);
        }
    }
    public static void addFactory(Token token,Function<String, Computable> factory){
        TOKEN_FACTORY.put(token,factory);
    }

    public static Token getToken(String e) {
        Token var= TOKEN_VALUE.get(e);
        if(var==null){
            if(isNumber(e))
            {
                return Token.NUMBER;
            }
            throw new IllegalArgumentException();
        }
        return var;
    }

    public static Function<String, Computable> getFactory(Token token){
        Function<String, Computable> factory= TOKEN_FACTORY.get(token);

        if(factory==null){
            throw new IllegalArgumentException();
        }
        return factory;
    }

    private static boolean isNumber(String op){
        try {
            int result = Integer.parseInt(op);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
