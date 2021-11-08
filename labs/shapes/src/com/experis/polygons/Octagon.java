package com.experis.polygons;

import com.experis.Shapes.Point;

public class Octagon extends Polygon {
    public Octagon(Point... octagon) {
        super(octagon);

        if (octagon.length != 8) {
            throw new IllegalArgumentException("It's not Octagon");
        }
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "i'm Octagon";
    }
}
