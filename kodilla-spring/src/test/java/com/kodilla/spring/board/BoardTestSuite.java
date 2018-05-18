package com.kodilla.spring.board;

import com.kodilla.spring.portfolio.Board;
import com.kodilla.spring.portfolio.BoardConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board sutBoard = (Board)context.getBean("board");
        //When
        sutBoard.addTaskDoneList("First done task");
        sutBoard.addTaskInProgresList("First inProgress task");
        sutBoard.addTaskToDoList("First toDo task");
        //Then
        Assert.assertTrue(sutBoard.getToDoList().contains("First toDo task"));
        Assert.assertTrue(sutBoard.getInProgressList().contains("First inProgress task"));
        Assert.assertTrue(sutBoard.getDoneList().contains("First done task"));

        Assert.assertFalse(sutBoard.getInProgressList().contains("First done task"));
    }
}
