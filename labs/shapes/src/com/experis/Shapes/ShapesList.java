package com.experis.Shapes;

import com.experis.Shapes.Shapes;

import java.util.ArrayList;

public class ShapesList {
    public ArrayList<Shapes> shapes = new ArrayList<>();

    public void addShape(Shapes shape) {
        shapes.add(shape);
    }

    public void remove(Shapes shape) {
        shapes.remove(shape);
    }
}
