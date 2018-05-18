package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskList {
    List<String> tasks;

    @Autowired
    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTaskToList(String task) {
        tasks.add(task);
    }

    public boolean contains(String task) {
        return tasks.contains(task);
    }

}
