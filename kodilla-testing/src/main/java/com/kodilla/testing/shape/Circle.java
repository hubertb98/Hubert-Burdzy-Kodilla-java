package com.kodilla.testing.shape;

import static java.lang.Math.*;

public class Circle implements Shape {
    private String name = "Circle";
    private double r;
    private double field;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        field = PI * pow(r, 2);
        return field;
    }
}
