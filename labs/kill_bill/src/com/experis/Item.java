package com.experis;

import java.util.Locale;

public record Item(String itemDescription, int quantity, double unitPrice, String currency) {

    @Override
    public String toString() {
        return itemDescription + "::"
                + quantity + "::"
                + unitPrice + "::"
                + currency;
    }
}
