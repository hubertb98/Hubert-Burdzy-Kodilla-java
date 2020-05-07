package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;
    private ShapeCollector shapeCollector;

    @Before
    public void beforeAllTests() {
        testCounter ++;
        shapeCollector = new ShapeCollector();
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        Shape shape = new Circle(3);

        //When
        shapeCollector.addFigure(shape);
        int collectionSize = shapeCollector.getShapeCollection().size();

        //Then
        Assert.assertEquals(1, collectionSize);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Shape shape = new Circle(3);
        shapeCollector.addFigure(shape);

        //When
        boolean result = shapeCollector.removeFigure(shape);
        int collectionSize = shapeCollector.getShapeCollection().size();

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, collectionSize);

    }

    @Test
    public void testGetFigure() {
        //Given
        Shape shape = new Square(3);
        shapeCollector.addFigure(shape);

        //When
        Shape result = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(shape, result);

    }

    @Test
    public void testShowFigure() {
        //Given
        Shape shape = new Circle(5);
        shapeCollector.addFigure(shape);

        //When
        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(shape);

        //Then
        Assert.assertEquals(shapeList.toString(), shapeCollector.showFigures());
    }
}
