package com.experis.calcInvoice;

import java.util.Locale;

public record Item(String itemDescription, int quantity, Money money) {

}
