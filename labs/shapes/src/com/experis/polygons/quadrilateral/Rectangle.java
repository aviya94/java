package com.experis.polygons.quadrilateral;

import com.experis.Shapes.Point;

public class Rectangle extends Quadrilateral {
    double length;
    double width;

    public Rectangle(Point upLeft, Point upRight, Point downRight, Point downLeft) {

        super(upLeft, upRight, downRight, downLeft);
        if (isRectangle(upLeft, upRight, downRight, downLeft) == false) {
            throw new IllegalArgumentException("It's not a rectangle");
        }

        this.length = length;
        this.width = width;

    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "i'm Rectangle";
    }
}
