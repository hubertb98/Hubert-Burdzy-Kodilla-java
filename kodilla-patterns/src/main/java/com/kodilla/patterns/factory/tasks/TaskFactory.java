package com.kodilla.patterns.factory.tasks;


public class TaskFactory {
    public static final String SHOPPING = "Shopping Task";
    public static final String PAINTING = "Painting Task";
    public static final String DRIVING = "Driving Task";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Go to the shopping center", "buts", 1);
            case PAINTING:
                return new PaintingTask("Paint something", "brown", "dog");
            case DRIVING:
                return new DrivingTask("Go to the sea", "Poland", "car");
            default:
                return null;
        }
    }
}
