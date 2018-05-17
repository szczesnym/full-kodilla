package com.kodilla.good.patterns.food2door;

public class Food2DoorOrder {
    private Food2DoorItem orderItem;
    private double orderQuantity;

    public Food2DoorOrder(Food2DoorItem orderItem, double orderQuantity) {
        this.orderItem = orderItem;
        this.orderQuantity = orderQuantity;
    }

    public Food2DoorItem getOrderItem() {
        return orderItem;
    }

    public double getOrderQuantity() {
        return orderQuantity;
    }
}
