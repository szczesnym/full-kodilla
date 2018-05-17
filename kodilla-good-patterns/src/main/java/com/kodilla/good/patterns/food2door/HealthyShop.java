package com.kodilla.good.patterns.food2door;

public class HealthyShop extends Food2DoorSupplier{
    public HealthyShop() {
        super("HealthyShop");
    }

    public boolean process() {
        System.out.println("Processing order for Healthy Shop...");
        return true;
    }

    public String connectToSupplier() {
        System.out.println("Connecting to HealthyShop");
        return "Healthyshop_CONNECTION";
    }

    public Food2DoorItem itemNoMapper(Food2DoorItem itemByF2D) {
        String itemByHS = "HS_" +itemByF2D.getItemNo();
        System.out.format("Mapping items for supplier EFS : %s -> %s\n", itemByF2D.getItemNo(), itemByHS);
        return new Food2DoorItem(itemByHS, itemByF2D.getItemName(), ItemType.SupplierItem );
    }
}
