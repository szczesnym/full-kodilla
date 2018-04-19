package com.kodilla.testing.Shapes;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ShapeTestSuite {
    private static int testCounter = 0;

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddShapeNotNull() {
        //Given
        Shape testShape = new Circle(5);
        //When
        ShapeCollector listOfShapes = new ShapeCollector();
        listOfShapes.addShapeToList(testShape);
        //Then
        Assert.assertEquals(1, listOfShapes.countShapes());
    }

    @Test
    public void testAddShapeNull() {
        //Given
        ShapeCollector listOfShapes = new ShapeCollector();
        //When
        listOfShapes.addShapeToList(null);
        //Then
        Assert.assertEquals(0, listOfShapes.countShapes());
    }

    @Test
    public void testRemoveShapeNotNull() {
        //Given
        Shape testShape = new Triangle(5, 5, 5);
        ShapeCollector sutShapeCollector = new ShapeCollector();
        //When
        sutShapeCollector.addShapeToList(testShape);
        boolean testResult = sutShapeCollector.removeShapeFromList(testShape);
        //Then
        Assert.assertTrue(testResult);
    }

    @Test
    public void testRemoveShapeFromListNull() {
        ShapeCollector sutShapeCollector = new ShapeCollector();
        //When
        sutShapeCollector.addShapeToList(null);
        boolean testResult = sutShapeCollector.removeShapeFromList(null);
        //Then
        Assert.assertFalse(testResult);
    }

    @Test
    public void testRemoveShapeFromListNotNullExisting() {
        //Given
        Shape sutShape = new Circle(6);
        ShapeCollector sutShapeCollector = new ShapeCollector();
        //When
        sutShapeCollector.addShapeToList(sutShape);
        boolean testResult = sutShapeCollector.removeShapeFromList(sutShape);
        //Then
        Assert.assertTrue(testResult);
    }

    @Test
    public void testRemoveShapeFromListNotNullNotExisting() {
        //Given
        Shape sutShape = new Circle(6);
        ShapeCollector sutShapeCollector = new ShapeCollector();
        //When
        sutShapeCollector.addShapeToList(new Triangle(5, 5, 5));
        //Then
        Assert.assertFalse(sutShapeCollector.removeShapeFromList(sutShape));
    }

    @Test
    public void testNFigureFromList() {
        //Given
        Shape sutShape = new Square(6);
        ShapeCollector sutShapeCollector = new ShapeCollector();
        //When
        sutShapeCollector.addShapeToList(sutShape);
        Shape resultShape = sutShapeCollector.nFigureFromList(0);
        //Then
        Assert.assertEquals(sutShape, resultShape);
    }
    @Test
    public void testNFigureFromListNotExisting() {
        //Given
        Shape sutShape = new Circle(4);
        ShapeCollector sutShapeCollector = new ShapeCollector();
        //When
        sutShapeCollector.addShapeToList(sutShape);
        Shape resultShape = sutShapeCollector.nFigureFromList(1);
        //Then
        Assert.assertNull(resultShape);
    }

}
