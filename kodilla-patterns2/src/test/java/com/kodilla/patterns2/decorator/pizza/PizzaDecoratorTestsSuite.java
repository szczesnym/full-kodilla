package com.kodilla.patterns2.decorator.pizza;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaDecoratorTestsSuite {
    private PizzaOrder pizzaOrder;

    @Before
    public void init() {
        pizzaOrder = new BasicPizzaOrder();
    }

    @Test
    public void basicPizzaTest() {
        //Given
        //When
        double pizzaCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        //Then
        assertEquals(15.0, pizzaCost, 0.001);
        assertEquals("Pizza with tomato sauce and cheese", pizzaDescription);
    }

    @Test
    public void withHamBasicPizzaTest() {
        //Given
        pizzaOrder = new AddHamDecorator(pizzaOrder);
        //When
        double pizzaCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        //Then
        assertEquals(18.5, pizzaCost, 0.001);
        assertEquals("Pizza with tomato sauce and cheese with additional ham", pizzaDescription);
    }

    @Test
    public void withMushroomBasicPizzaTest() {
        //Given
        pizzaOrder = new AddMushroomDecorator(pizzaOrder);
        //When
        double pizzaCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        //Then
        assertEquals(17.7, pizzaCost, 0.001);
        assertEquals("Pizza with tomato sauce and cheese with additional mushroom", pizzaDescription);
    }

    @Test
    public void withCheeseBasicPizzaTest() {
        //Given
        pizzaOrder = new AddCheeseDecorator(pizzaOrder);
        //When
        double pizzaCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        //Then
        assertEquals(16.9, pizzaCost, 0.001);
        assertEquals("Pizza with tomato sauce and cheese with additional cheese", pizzaDescription);
    }

    @Test
    public void withCheeseCheeseHamMushroomBasicPizzaTest() {
        //Given
        pizzaOrder = new AddCheeseDecorator(pizzaOrder);
        pizzaOrder = new AddCheeseDecorator(pizzaOrder);
        pizzaOrder = new AddHamDecorator(pizzaOrder);
        pizzaOrder = new AddMushroomDecorator(pizzaOrder);
        //When
        double pizzaCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        //Then
        assertEquals(25.0, pizzaCost, 0.001);
        assertEquals("Pizza with tomato sauce and cheese with additional cheese with additional cheese with additional ham with additional mushroom", pizzaDescription);
    }


}
