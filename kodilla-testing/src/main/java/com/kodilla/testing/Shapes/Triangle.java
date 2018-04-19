package com.kodilla.testing.Shapes;

public class Triangle implements Shape {
    private double sideA, sideB, sideC;

    @Override
    public double sizeOfFigure() {
        double pParam = (this.sideA + this.sideB + this.sideC) / 2;
        return Math.sqrt(pParam * (pParam - sideA) * (pParam - this.sideB) * (pParam -this.sideC));
    }

    @Override
    public String nameOfFigure() {
        return "Triangle";
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
}
