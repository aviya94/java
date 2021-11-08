package com.experis.tests;


import com.experis.Shapes.Distance;
import com.experis.Shapes.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    @Test
    void distance() {
        Point firstPoint = new Point(4, 6);
        Point secondPoint = new Point(-5, -4);
        Double result = Distance.getDistance(firstPoint, secondPoint);
        Double excepted = 13.45362404707371;
        assertEquals(excepted, result);
    }

    @Test
    void distance_zero() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(0, 0);
        Double result = Distance.getDistance(firstPoint, secondPoint);
        Double excepted = 0.0;
        assertEquals(excepted, result);
    }
}
