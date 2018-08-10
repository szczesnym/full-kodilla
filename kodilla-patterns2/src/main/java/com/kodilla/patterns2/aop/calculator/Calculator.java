package com.kodilla.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class Calculator {
    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) throws ArithmeticException {
        try {
            return x / y;
        } catch(ArithmeticException ae) {
            throw new ArithmeticException("Division by zero !!!");
        }
    }
    public double fac(double x) {
        if(x <= 0) return 0;
        if(x == 1) {
            return 1;
        } else {
            return x * fac(x -1);
        }

    }
}
