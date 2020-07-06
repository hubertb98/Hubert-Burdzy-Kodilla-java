package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);

        TaskList toDoList = board.getToDoList();
        TaskList inProgressList = board.getInProgressList();
        TaskList doneList = board.getDoneList();

        toDoList.addTask("Read 10 pages of book");
        inProgressList.addTask("Make dinner");
        doneList.addTask("Drink a glass of water after waking up");
        //When

        String toDoTask = toDoList.getTaskFromList(0);
        String inProgressTask = inProgressList.getTaskFromList(0);
        String doneTask = doneList.getTaskFromList(0);

        //Then
        Assert.assertEquals("Read 10 pages of book", toDoTask);
        Assert.assertEquals("Make dinner", inProgressTask);
        Assert.assertEquals("Drink a glass of water after waking up", doneTask);
    }
}
