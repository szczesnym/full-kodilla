package com.kodilla.testing.Shapes;

class Circle implements Shape {
    private double radius;

    @Override
    public String nameOfFigure() {
        return "Circle";
    }
    @Override
    public double  sizeOfFigure() {
        return Math.pow(2,this.radius) * Math.PI;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
