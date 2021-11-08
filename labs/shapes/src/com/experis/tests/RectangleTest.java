package com.experis.tests;

import com.experis.Shapes.Point;
import com.experis.polygons.quadrilateral.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RectangleTest {
    Rectangle rectangle;

    @Test
    void fail_hexagon() {
        try {
            rectangle = new Rectangle(new Point(4, 0), new Point(4, 2),
                    new Point(3, 5), new Point(0, 0));
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void area_hexagon() {

        rectangle = new Rectangle(new Point(4, 0), new Point(4, 4),
                new Point(0, 4), new Point(0, 0));

        double result = rectangle.AreaCalculation();
        double excepted = 16;
        assertEquals(excepted, result);

    }
}
