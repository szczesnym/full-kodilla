package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "items")
public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
