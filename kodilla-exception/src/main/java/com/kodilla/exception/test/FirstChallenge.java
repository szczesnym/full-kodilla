package com.kodilla.exception.test;

public class FirstChallenge {
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException aE) {
            System.out.println("Arithmetic EX catched:" + aE.getMessage());
        }
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by 0 is no allowed");
        }
        return a / b;
    }
}
