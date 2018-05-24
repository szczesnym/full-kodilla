package com.kodilla.spring.portfolio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    @Autowired
    @Bean
    public Board board() {


        TaskList toDo = new TaskList();
        TaskList inProgress = new TaskList();
        TaskList done = new TaskList();
        return new Board(toDo, inProgress, done);
    }

    @Bean(name = "toDoTaskList")
    public TaskList getToDo() {
        return new TaskList();
    }

    @Bean(name = "inProgressTaskList")
    public TaskList getInProgress() {
        return new TaskList();
    }

    @Bean(name = "doneTaskList")
    public TaskList geDone() {
        return new TaskList();
    }

}
