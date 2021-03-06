package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest


public class CalculatorTestSuite {
    @Test
    public void testCalculations() throws ArithmeticException{
    //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
     //When
     double sutAddResult = calculator.add(2.5, 3.0);
     double sutSubResult = calculator.sub(2.5, 3.0);
     double sutMulResult = calculator.mul(2.5, 3.0);
     double sutDivResult = calculator.div(2.5, 3.0);
     //Then
        Assert.assertEquals(5.5, sutAddResult, 0.001);
        Assert.assertEquals(-0.5, sutSubResult, 0.001);
        Assert.assertEquals(7.5, sutMulResult, 0.001);
        Assert.assertEquals(0.833, sutDivResult, 0.001);
    }
}
