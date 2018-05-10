package com.kodilla.good.patterns.chalanges;


public abstract class Order {
    private double quantity;
    private double pricePerUnit;

    public Order(double quantity, double pricePerUnit) {
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double orderValue() {
        return quantity * pricePerUnit;
    }
}
