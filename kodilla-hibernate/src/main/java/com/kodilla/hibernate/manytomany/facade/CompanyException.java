package com.kodilla.hibernate.manytomany.facade;

public class CompanyException extends Exception{
    public static String WRN_NOT_FOUND = "Employee was no found";

    public CompanyException(String message) {
        super(message);
    }
}
