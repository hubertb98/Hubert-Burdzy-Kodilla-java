package com.kodilla.testing.shape;

import static java.lang.Math.sqrt;

public class Triangle implements Shape {
    private String name = "Triangle";
    private double a;
    private double b;
    private double c;
    private double p;
    private double field;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        if (( a + b > c) && (b + c > a) && (a + c > b)) {
            p = (a + b + c) / 2;
            field = sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return field;
    }
}
