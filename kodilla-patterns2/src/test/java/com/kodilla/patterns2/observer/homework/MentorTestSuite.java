package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MentorTestSuite {

    @Test
    public void testUpdate() {
        //Given
        TaskQueue springTasks = new TaskQueue("Spring Tasks");
        TaskQueue designPatternTasks = new TaskQueue("Design Pattern Tasks");
        TaskQueue dbTasks = new TaskQueue("Database Tasks");
        TaskQueue frontendTasks = new TaskQueue("Frontend Tasks");

        Mentor mateusz = new Mentor("Mateusz");
        Mentor pawel = new Mentor("Pawel");

        dbTasks.registerObserver(pawel);
        frontendTasks.registerObserver(pawel);
        springTasks.registerObserver(mateusz);
        designPatternTasks.registerObserver(mateusz);

        //When
        springTasks.addTask("Calculator with display");
        springTasks.addTask("Mapping controller method");
        springTasks.addTask("All in one");

        designPatternTasks.addTask("Decorate pizza");
        designPatternTasks.addTask("Compose our own BigMac");
        designPatternTasks.addTask("Queues with tasks to be checked");
        designPatternTasks.addTask("Clone library");

        dbTasks.addTask("Create tables with tasks");
        dbTasks.addTask("Create task list entity");

        frontendTasks.addTask("Create todo website");
        frontendTasks.addTask("Add button to todo website");

        //Then
        assertEquals(4, pawel.getUpdateCount());
        assertEquals(7, mateusz.getUpdateCount());
    }
}
