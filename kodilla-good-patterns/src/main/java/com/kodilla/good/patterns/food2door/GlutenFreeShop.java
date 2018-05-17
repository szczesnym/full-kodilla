package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop extends Food2DoorSupplier {
    public GlutenFreeShop() {
        super("GlutenFreeShop");
    }
    public boolean process() {
        System.out.println("Processing order for Gluten Free Shop...");
        return true;
    }

    public String connectToSupplier() {
        System.out.println("Connecting to Gluten Free Shop");
        return "GlutenFree_CONNECTION";
    }

    public Food2DoorItem itemNoMapper(Food2DoorItem itemByF2D) {
        String itemByGFS = "GFS_" +itemByF2D.getItemNo();
        System.out.format("Mapping items for supplier GFS : %s -> %s\n", itemByF2D.getItemNo(), itemByGFS);
        return new Food2DoorItem(itemByGFS, itemByF2D.getItemName(), ItemType.SupplierItem );
    }
}
