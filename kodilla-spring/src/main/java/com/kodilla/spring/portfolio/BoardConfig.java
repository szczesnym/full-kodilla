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

    @Bean
    public TaskList taskList() {
        return new TaskList();
    }
}
