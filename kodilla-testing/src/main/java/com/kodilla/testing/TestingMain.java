package com.kodilla.testing;

import java.lang.*;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("6. Wprowadzenie do testowania");
        Calculator calculator = new Calculator();
        float sumTest = calculator.addNumbers(5, 4);
        if( sumTest == 9) {
            System.out.println("TEST: calculator.addNumbers -> OK");
        } else {
            System.out.println("TEST: calculator.addNumbers -> FAILED");
        }
        float subtractTest = calculator.subtractNumbers(5, 4);
        if( subtractTest == 7) {
            System.out.println("TEST: calculator.subtractNumbers -> OK");
        } else {
            System.out.println("TEST: calculator.subtractNumbers -> FAILED");
        }
    }
}
