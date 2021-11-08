package com.experis.tests;


import com.experis.Shapes.Point;
import com.experis.polygons.Hexagon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HexagonTest {

    Hexagon hexagon;

    @Test
    void fail_hexagon() {
        try {
            hexagon = new Hexagon(new Point(1, 2), new Point(2, 4), new Point(4, 2));
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void area_hexagon() {

        hexagon = new Hexagon(new Point(1, 2), new Point(2, 7), new Point(3, 3)
                , new Point(5, 4), new Point(6, 0), new Point(12, 11));

        double result = hexagon.AreaCalculation();
        double excepted = 20;
        assertEquals(excepted, result);

    }

}
