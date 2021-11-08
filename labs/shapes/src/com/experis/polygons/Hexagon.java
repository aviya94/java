package com.experis.polygons;

import com.experis.Shapes.Point;

public class Hexagon extends Polygon {
    public Hexagon(Point... hexagon) {
        super(hexagon);

        if (hexagon.length != 6) {
            throw new IllegalArgumentException("It's not hexagonal");
        }
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "i'm Hexagon";
    }
}
