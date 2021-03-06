package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Calculator {
    private final Display display;
    private double result;

    @Autowired
    public Calculator(Display display) {
        this.display = display;
    }

    public double add(double a, double b) {
        this.result = a + b;
        this.display.displayValue(result);
        return result;
    }

    public double sub(double a, double b) {
        this.result = a - b;
        this.display.displayValue(result);
        return result;
    }

    public double mul(double a, double b) {
        this.result = a * b;
        this.display.displayValue(result);
        return result;
    }

    public double div(double a, double b) throws ArithmeticException{
        this.result = a / b;
        this.display.displayValue(result);
        return result;
    }

}
