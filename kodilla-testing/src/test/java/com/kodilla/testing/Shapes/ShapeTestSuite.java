package com.kodilla.testing.Shapes;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ShapeTestSuite {
    private static int testCounter = 0;
    private ShapeCollector sutShapeCollector;


    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
        this.sutShapeCollector = new ShapeCollector();
    }

    @Test
    public void testAddShapeNotNull() {
        //Given
        Shape testShape = new Circle(5);
        //When
        boolean testResult = sutShapeCollector.addShapeToList(testShape);
        //Then
        Assert.assertEquals(true, testResult);
    }

    @Test
    public void testAddShapeNull() {
        //Given
        //When
        boolean testResult = sutShapeCollector.addShapeToList(null);
        //Then
        Assert.assertEquals(false, testResult);
    }

    @Test
    public void testRemoveShapeNotNull() {
        //Given
        Shape testShape = new Triangle(5, 5, 5);
        sutShapeCollector.addShapeToList(testShape);
        //When
        boolean testResult = sutShapeCollector.removeShapeFromList(testShape);
        //Then
        Assert.assertTrue(testResult);
    }

    @Test
    public void testRemoveShapeFromListNull() {
        //Given
        sutShapeCollector.addShapeToList(null);
        //When
        boolean testResult = sutShapeCollector.removeShapeFromList(null);
        //Then
        Assert.assertFalse(testResult);
    }

    @Test
    public void testRemoveShapeFromListNotNullExisting() {
        //Given
        Shape sutShape = new Circle(6);
        sutShapeCollector.addShapeToList(sutShape);
        //When
        boolean testResult = sutShapeCollector.removeShapeFromList(sutShape);
        //Then
        Assert.assertTrue(testResult);
    }

    @Test
    public void testRemoveShapeFromListNotNullNotExisting() {
        //Given
        Shape sutShape = new Circle(6);
        //When
        sutShapeCollector.addShapeToList(new Triangle(5, 5, 5));
        //Then
        Assert.assertFalse(sutShapeCollector.removeShapeFromList(sutShape));
    }

    @Test
    public void testNFigureFromList() {
        //Given
        Shape sutShape = new Square(6);
        sutShapeCollector.addShapeToList(sutShape);
        //When
        Shape resultShape = sutShapeCollector.nFigureFromList(0);
        //Then
        Assert.assertEquals(sutShape, resultShape);
    }

    @Test
    public void testNFigureFromListNotExisting() {
        //Given
        Shape sutShape = new Circle(4);
        sutShapeCollector.addShapeToList(sutShape);
        //When
        Shape resultShape = sutShapeCollector.nFigureFromList(1);
        //Then
        Assert.assertNull(resultShape);
    }

}
