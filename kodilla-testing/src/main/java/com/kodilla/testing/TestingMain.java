package com.kodilla.testing;

import java.lang.*;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("6. Wprowadzenie do testowania");
        Calculator calculator = new Calculator();
        System.out.format("SUM %f", calculator.addNumbers(5, 4));
        System.out.format("SUM %f\n", calculator.addNumbers(5, 4));
        System.out.format("DIVISION %f\n", calculator.divideNumbers(5, 4));
    }
}
