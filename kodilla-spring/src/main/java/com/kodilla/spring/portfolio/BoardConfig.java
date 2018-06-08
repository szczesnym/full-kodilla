package com.kodilla.spring.portfolio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    @Bean
    public Board board() {
        return new Board();
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
