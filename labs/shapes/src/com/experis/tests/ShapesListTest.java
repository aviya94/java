package com.experis.tests;

import com.experis.Shapes.Point;
import com.experis.Shapes.ShapesList;
import com.experis.polygons.Hexagon;
import com.experis.polygons.quadrilateral.Rectangle;
import com.experis.polygons.quadrilateral.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShapesListTest {
    ShapesList shapesList;

    @BeforeEach
    void setUp() {
        shapesList = new ShapesList();
        shapesList.addShape(new Rectangle(new Point(4, 0), new Point(4, 4),
                new Point(0, 4), new Point(0, 0)));
        shapesList.addShape(new Square(new Point(4, 0), new Point(4, 4),
                new Point(0, 4), new Point(0, 0)));
        shapesList.addShape(new Hexagon(new Point(1, 2), new Point(2, 4), new Point(4, 2)
                , new Point(8, 9), new Point(4, 6), new Point(8, 10)));
    }

    @Test
    void add_shape() {
        String rectangle = "i'm Rectangle";
        assertEquals(rectangle, shapesList.shapes.get(0).toString());

        String square = "i'm Square";
        assertEquals(square, shapesList.shapes.get(1).toString());

        String hexagon = "i'm Hexagon";
        assertEquals(hexagon, shapesList.shapes.get(2).toString());
    }

}
