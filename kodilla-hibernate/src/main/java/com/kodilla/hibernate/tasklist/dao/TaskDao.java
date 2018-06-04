package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TaskDao extends CrudRepository<TaskList, Integer> {
    List<TaskList> findByListName(String listName);

}