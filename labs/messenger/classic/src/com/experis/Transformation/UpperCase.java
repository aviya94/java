package com.experis.Transformation;


public class UpperCase implements Transform<String> {
    public String transforn(String message) {
        return message.toUpperCase();
    }

}
