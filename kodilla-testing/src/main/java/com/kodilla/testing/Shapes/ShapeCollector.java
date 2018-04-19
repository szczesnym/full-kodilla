package com.kodilla.testing.Shapes;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> listOfShapes;

    public ShapeCollector() {
        this.listOfShapes = new ArrayList<Shape>();
    }

    public void showFigures() {
        for (Shape shape : listOfShapes) {
            System.out.format("Figure no:%d, %s", listOfShapes.indexOf(shape), shape.nameOfFigure());
        }
    }

    public void addShapeToList(Shape shape) {
        if (shape != null) {
            this.listOfShapes.add(shape);
        }
    }

    public int countShapes() {
        return this.listOfShapes.size();
    }

    public boolean removeShapeFromList(Shape shape) {
        if (this.listOfShapes.size() > 0) {
            return this.listOfShapes.remove(shape);
        } else {
            return false;
        }
    }

    public Shape nFigureFromList(int index) {
        if (index >= this.listOfShapes.size()) {
            return null;
        } else {
            return this.listOfShapes.get(index);
        }
    }
}
