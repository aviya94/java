package com.experis.Shapes;

public abstract class Distance {

    public static double getDistance(Point firsPoint, Point secondPoint) {
        return Math.sqrt(Math.pow(firsPoint.x() - secondPoint.x(), 2) + Math.pow(firsPoint.y() - secondPoint.y(), 2));
    }
}
