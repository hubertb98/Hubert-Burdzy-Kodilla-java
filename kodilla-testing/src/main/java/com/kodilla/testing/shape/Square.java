package com.kodilla.testing.shape;

import static java.lang.Math.pow;

public class Square implements Shape {
    private String name = "Square";
    private double a;
    private double field;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        field = pow(a, 2);
        return field;
    }
}
