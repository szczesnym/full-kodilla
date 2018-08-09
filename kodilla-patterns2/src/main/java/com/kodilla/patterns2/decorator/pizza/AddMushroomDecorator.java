package com.kodilla.patterns2.decorator.pizza;

public class AddMushroomDecorator extends AbstractPizzaOrderDecorator {
    private static final double COST_OF_MUSHROOM = 2.7;

    public AddMushroomDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + COST_OF_MUSHROOM;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with additional mushroom";
    }
}
