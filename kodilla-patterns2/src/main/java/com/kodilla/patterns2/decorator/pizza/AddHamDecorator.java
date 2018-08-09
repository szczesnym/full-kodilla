package com.kodilla.patterns2.decorator.pizza;

public class AddHamDecorator extends AbstractPizzaOrderDecorator {
    private static final double COST_OF_HAM = 3.5;

    public AddHamDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + COST_OF_HAM;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with additional ham";
    }
}
