package com.experis.tests;

import com.experis.Shapes.Point;
import com.experis.polygons.quadrilateral.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SquareTest {
    Square square;

    @Test
    void fail_hexagon() {
        try {
            square = new Square(new Point(0, 2), new Point(4, 2),
                    new Point(2, 0), new Point(0, 0));
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void area_hexagon() {

        square = new Square(new Point(4, 0), new Point(4, 4),
                new Point(0, 4), new Point(0, 0));

        double result = square.AreaCalculation();
        double excepted = 16;
        assertEquals(excepted, result);

    }
}
