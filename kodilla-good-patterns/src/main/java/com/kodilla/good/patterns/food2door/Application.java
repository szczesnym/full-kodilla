package com.kodilla.good.patterns.food2door;

public class Application {

    public static void main(String[] args) {
        Food2DoorItem testItem1 = new Food2DoorItem("Bread", "New Bread", ItemType.F2DItem);
        Food2DoorItem testItem2 = new Food2DoorItem("GFBread", "Gluten Free  Bread", ItemType.F2DItem);
        Food2DoorItem testItem3 = new Food2DoorItem("Water", "Mineral Water", ItemType.F2DItem);

        Food2DoorOrder testOrder1 = new Food2DoorOrder(testItem1, 10.0);
        Food2DoorOrder testOrder2 = new Food2DoorOrder(testItem2, 10.0);
        Food2DoorOrder testOrder3 = new Food2DoorOrder(testItem3, 10.0);

        Food2DoorSupplier testSupplier1 = new ExtraFoodShop();
        Food2DoorSupplier testSupplier2 = new HealthyShop();
        Food2DoorSupplier testSupplier3 = new GlutenFreeShop();

        Food2DoorOrderProcessor orderProcessor = new Food2DoorOrderProcessor();
        System.out.format("Order status by EFS:%s\n\n", orderProcessor.placeOrder(testSupplier1, testOrder1));
        System.out.format("Order status by HS:%s\n\n", orderProcessor.placeOrder(testSupplier2, testOrder2));
        System.out.format("Order status by GFS:%s\n\n", orderProcessor.placeOrder(testSupplier3, testOrder3));
    }
}
