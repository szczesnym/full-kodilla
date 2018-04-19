package com.kodilla.testing.Shapes;

public class Square implements Shape {
    private double side;

    @Override
    public double sizeOfFigure() {
        return Math.pow(2,this.side);
    }

    @Override
    public String nameOfFigure() {
        return "Square";
    }

    public Square(double side) {
        this.side = side;
    }
}
