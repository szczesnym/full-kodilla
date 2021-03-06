package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
//@NamedNativeQueries(
//        {
        @NamedNativeQuery(
                name = "Company.firstThreeCharactersAreEqualParam",
                query = "Select * From companies where left(company_name, 3) = :COMPANY_NAME_START ",
                resultClass = Company.class
        )
/*
        @NamedNativeQuery(
                name = "Company.withNamesContainsParam",
                query = "select * from companies where company_name LIKE %:COMPANY_NAME_PARAM%",
                resultClass = Company.class
        )
    }
Do dyskusji na telco


)*/
@Entity
@Table(name = "Companies")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "company_id", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "company_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
