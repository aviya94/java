package com.aviya.exchnage;
import java.math.BigDecimal;

public record Currency(String currencyCode, BigDecimal rate) {
}
