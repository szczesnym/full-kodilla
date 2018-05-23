package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskFactoryTestSuite {
    TaskFactory taskFactory;
    CommonTask drivingTask, paintingTask, shoppingTask;

    @Before
    public void init() {
        taskFactory = new TaskFactory();
        drivingTask = taskFactory.makeTask(TaskEnum.Driving);
        paintingTask = taskFactory.makeTask(TaskEnum.Painting);
        shoppingTask = taskFactory.makeTask(TaskEnum.Shopping);
    }
    @Test
    public void executedTest() {
        //Given
        //When
        drivingTask.executeTask();
        shoppingTask.executeTask();
        paintingTask.executeTask();
        //Then
        Assert.assertTrue(drivingTask.isTaskExecuted());
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    public void classTypeTest() {
        //Given
        //When
        boolean drivingTrueResult = drivingTask instanceof DrivingTask;
        boolean shoppingTrueResult = shoppingTask instanceof ShoppingTask;
        boolean paintingTrueResult = paintingTask instanceof PaintingTask;

        boolean drivingFalseResult = drivingTask instanceof PaintingTask;
        //Then
        Assert.assertTrue(drivingTrueResult);
        Assert.assertTrue(shoppingTrueResult);
        Assert.assertTrue(paintingTrueResult);
        Assert.assertFalse(drivingFalseResult);
    }

}
