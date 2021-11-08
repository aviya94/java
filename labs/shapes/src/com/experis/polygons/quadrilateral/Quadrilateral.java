package com.experis.polygons.quadrilateral;


import com.experis.Shapes.Distance;
import com.experis.Shapes.Point;
import com.experis.polygons.Polygon;

public abstract class Quadrilateral extends Polygon {

    public Quadrilateral(Point... quadrilateral) {
        super(quadrilateral);
        if (quadrilateral.length != 4) {
            throw new IllegalArgumentException("It's not a rectangle Quadrilateral");
        }
    }

    protected Boolean isSquare(Point upLeft, Point upRight, Point downRight, Point downLeft) {

        if (isRectangle(upLeft, upRight, downRight, downLeft) == false) {
            return false;
        }

        Double firstSide = Distance.getDistance(upLeft, upRight);
        Double secondSide = Distance.getDistance(upRight, downRight);

        return firstSide.equals(secondSide);
    }

    protected boolean isRectangle(Point upLeft, Point upRight, Point downRight, Point downLeft) {

        double firstSide = Distance.getDistance(upLeft, upRight);
        double secondSide = Distance.getDistance(upLeft, upRight);

        if (firstSide == secondSide) {
            double firstDiagonal = Distance.getDistance(upLeft, downRight);
            double secondDiagonal = Distance.getDistance(downLeft, upRight);

            return firstDiagonal == secondDiagonal;
        }
        return false;
    }
}
