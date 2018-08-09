package com.kodilla.patterns2.decorator.pizza;

public class AddCheeseDecorator extends AbstractPizzaOrderDecorator {
    private static final double COST_OF_CHEESE = 1.9;

    public AddCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + COST_OF_CHEESE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with additional cheese";
    }

}
