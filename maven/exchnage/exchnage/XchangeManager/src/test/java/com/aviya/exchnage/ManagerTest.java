package com.aviya.exchnage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Exchanger exchanger;

    @BeforeEach
    void setUp() {
        exchanger = new Exchanger();
    }

    @Test
    void convert() {
        var res = exchanger.Convert(new Currency("USD", new BigDecimal(3.111)),
                new Currency("EUR", new BigDecimal(3.5126)),
                new BigDecimal(100));
        MathContext m = new MathContext(5);
        BigDecimal excepted = new BigDecimal(88.5666).round(m);

        assertEquals(excepted, res.round(m));

    }
}