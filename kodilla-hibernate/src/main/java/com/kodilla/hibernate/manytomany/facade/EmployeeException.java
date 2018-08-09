package com.kodilla.hibernate.manytomany.facade;

public class EmployeeException extends Exception {
    public static String WRN_NOT_FOUND = "Employee was no found";

    public EmployeeException(String message) {
        super(message);
    }
}
