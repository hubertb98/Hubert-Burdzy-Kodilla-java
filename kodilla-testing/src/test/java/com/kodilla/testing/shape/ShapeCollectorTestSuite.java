package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Before;
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
        Shape shape1 = new Square(3);
        Shape shape2 = new Triangle(3,4,5);
        shapeCollector.addFigure(shape);
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);
        
        //When
        int collectionSize = shapeCollector.getShapeCollection().size();

        //Then
        Assert.assertEquals(3, collectionSize);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Shape shape = new Circle(3);
        Shape shape1 = new Square(3);
        Shape shape2 = new Triangle(3,4,5);
        shapeCollector.addFigure(shape);
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);

        //When
        boolean result = shapeCollector.removeFigure(shape);
        int collectionSize = shapeCollector.getShapeCollection().size();

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(2, collectionSize);

    }

    @Test
    public void testGetFigure() {
        //Given
        Shape shape = new Circle(3);
        Shape shape1 = new Square(3);
        Shape shape2 = new Triangle(3,4,5);
        shapeCollector.addFigure(shape);
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);

        //When
        Shape result = shapeCollector.getFigure(1);

        //Then
        Assert.assertEquals(shape1, result);

    }

    @Test
    public void testShowFigure() {
        //Given
        Shape shape = new Circle(3);
        Shape shape1 = new Square(3);
        Shape shape2 = new Triangle(3,4,5);
        shapeCollector.addFigure(shape);
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);

        //When
        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(shape);
        shapeList.add(shape1);
        shapeList.add(shape2);

        //Then
        Assert.assertEquals(shapeList.toString(), shapeCollector.showFigures());
    }
}
