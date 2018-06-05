package com.kodilla.hibernate.taskslist;


import com.kodilla.hibernate.tasklist.TaskListDao;
import com.kodilla.hibernate.tasklist.TasksList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TasksListDaoTestSuite {
    @Autowired
    private TaskListDao tasksListDao;
    private TasksList tasksList;

    @Test
    public void addToTasksListTest() {
        //Given
        TasksList tasksList = new TasksList("Test to-do list", "Test to-do taskList");
        //When
        tasksListDao.save(tasksList);
        int noOfTasks = tasksListDao.findByListName("Test to-do list").size();
        //Then
        Assert.assertEquals(1, noOfTasks);
        //Clean-up
        tasksListDao.delete(tasksList);
    }

    @Test
    public void testFindByListName() {
        List<TasksList> resultTaskList;
        //Given
        TasksList tasksList = new TasksList("Test findByListName name", "Test findByListName describption");
        //When
        tasksListDao.save(tasksList);
        resultTaskList = tasksListDao.findByListName("Test findByListName name");
        //Then
        //Czy da się to zrobić tak:
        // resultTaskList.stream().map(sutTaskList -> Assert.assertTrue(sutTaskList.equals(tasksList))).close();
        //kiedy asercje nie zwaracają wyników ?
        for (TasksList sutTaskList : resultTaskList) {
            Assert.assertEquals("Test findByListName name", sutTaskList.getListName());
            System.out.println("Assert test");
        }
    }
}
