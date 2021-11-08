package com.experis.polygons;

import com.experis.Shapes.Point;
import com.experis.Shapes.Shapes;

public abstract class Polygon implements Shapes {
    private final Point[] polygon;

    public Polygon(Point... polygon) {
        this.polygon = polygon;
    }

    public double AreaCalculation() {
        double area = 0;

        for (int i = 0; i < polygon.length - 1; i++) {
            area += (polygon[i].x() * polygon[i + 1].y()) - (polygon[i + 1].x() * polygon[i].y());
        }
        if (area < 0) {
            area *= -1;
        }
        return area * 0.5;
    }
}
