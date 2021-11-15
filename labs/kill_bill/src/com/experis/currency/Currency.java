package com.experis.currency;

import java.math.BigDecimal;

public record Currency(BigDecimal value, String code) {
}
