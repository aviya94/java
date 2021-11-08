package com.experis.circles;


import com.experis.Shapes.Distance;
import com.experis.Shapes.Point;
import com.experis.Shapes.Shapes;

public class Circle implements Shapes {
    private final double diameter;

    public Circle(Point firstPoint, Point secondPoint) {
        diameter = Distance.getDistance(firstPoint, secondPoint);
    }

    @Override
    public double AreaCalculation() {
        return Math.PI * Math.pow(diameter / 2, 2);
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "i'm Circle";
    }
}
