package com.experis.polygons.quadrilateral;


import com.experis.Shapes.Point;

public class Square extends Quadrilateral {

    public Square(Point upLeft, Point upRight, Point downRight, Point downLeft) {
        super(upLeft, upRight, downRight, downLeft);

        if (isSquare(upLeft, upRight, downRight, downLeft) == false) {
            throw new IllegalArgumentException("It's not a Square");
        }

    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "i'm Square";
    }
}
