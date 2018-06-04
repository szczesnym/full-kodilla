package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASKSLIST")
public class TaskList {
    private int id;
    private String listName;
    private String describtion;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescribtion() {
        return describtion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public TaskList() {
    }

    public TaskList(int id, String listName, String describtion) {
        this.id = id;
        this.listName = listName;
        this.describtion = describtion;
    }
}
