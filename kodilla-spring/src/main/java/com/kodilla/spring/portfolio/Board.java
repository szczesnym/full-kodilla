package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Board {
    private TaskList toDoList, inProgressList, doneList;


    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }
    @Bean(name = "toDoTaskList")
    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }


    public TaskList getDoneList() {
        return doneList;
    }

    public void addTaskToDoList(String toDoTask) {
        this.toDoList.addTaskToList(toDoTask);
    }

    public void addTaskInProgresList(String inProgresTask) {
        this.inProgressList.addTaskToList(inProgresTask);
    }

    public void addTaskDoneList(String doneTask) {
        this.doneList.addTaskToList(doneTask);
    }

}
