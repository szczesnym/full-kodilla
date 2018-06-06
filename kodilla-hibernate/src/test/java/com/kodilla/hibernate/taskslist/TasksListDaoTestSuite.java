package com.kodilla.hibernate.taskslist;


import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskListDao;
import com.kodilla.hibernate.tasklist.TasksList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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
        long initNoOfTasks = tasksListDao.count();
        tasksListDao.save(tasksList);
        long noOfTasks = tasksListDao.count();
        //Then
        Assert.assertEquals(initNoOfTasks +1, noOfTasks);
        //Clean-up
        tasksListDao.delete(tasksList);
    }

    @Test
    public void testFindByListName() {
        //Given
        TasksList tasksList = new TasksList("Test findByListName name", "Test findByListName describption");
        //When
        tasksListDao.save(tasksList);
        List<TasksList> resultTaskList = tasksListDao.findByListName("Test findByListName name");
        //Then
        resultTaskList.stream().forEach(sutTaskList -> Assert.assertEquals(sutTaskList.getListName(), tasksList.getListName()));
        //Clean up
        tasksListDao.delete(tasksList);
    }
    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        String LISTNAME = "To do List";
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TasksList taskList = new TasksList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTasksList(taskList);
        task2.setTasksList(taskList);

        //When
        tasksListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        //taskListDao.delete(id);
    }
}
