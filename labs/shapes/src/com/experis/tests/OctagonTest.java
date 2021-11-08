package com.experis.tests;

import com.experis.Shapes.Point;
import com.experis.polygons.Octagon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class OctagonTest {
    Octagon octagon;

    @Test
    void fail_hexagon() {
        try {
            octagon = new Octagon(new Point(1, 2), new Point(2, 4), new Point(4, 2));
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void area_hexagon() {

        octagon = new Octagon(new Point(1, 2), new Point(2, 4), new Point(4, 8)
                , new Point(5, 4), new Point(3, 2), new Point(2, 1)
                , new Point(1, 1), new Point(0, 0));

        double result = octagon.AreaCalculation();
        double excepted = 13;
        assertEquals(excepted, result);

    }
}
