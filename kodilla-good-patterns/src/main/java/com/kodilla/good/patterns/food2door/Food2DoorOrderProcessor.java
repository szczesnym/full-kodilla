package com.kodilla.good.patterns.food2door;

public class Food2DoorOrderProcessor {
    public boolean placeOrder(Food2DoorSupplier supplier, Food2DoorOrder order) {

        if(supplier.orderAvaiabilty(order)) {
            return supplier.process();
        } else {
            return false;
        }
    }
}
