package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<TasksList, Integer> {
    List<TasksList> findByListName(String listname);
    TasksList findById(int id);
}
