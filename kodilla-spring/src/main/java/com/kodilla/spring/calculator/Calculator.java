package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private final Display display;
    private double result;

    public Calculator(Display display) {
        this.display = display;
    }
    /*  @Autowired
    public void setDisplay(Display display) {
        this.display = display;
    }
    */
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


/*    public double operation(double a, double b, OperationEnum operation) throws ArithmeticException{
        double result = 0;

        switch(operation) {
            case ADD : {
                result = a + b;
                break;
            }
            case SUB: {
                result = a - b;
                break;
            }
            case MUL: {
                result = a * b;
                break;
            }
            case DIV: {
                result = a / b;
                break;
            }
        }
        this.display.displayValue(result);
        return result;
    }
*/
}
