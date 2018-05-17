package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop extends Food2DoorSupplier {
    public ExtraFoodShop() {
        super("ExtraFoodShop");
    }

    public boolean process() {
        System.out.println("Processing order for Extra Food Shop...");
        return true;
    }

    public String connectToSupplier() {
        System.out.println("Connecting to Extra Food Shop");
        return "ExtraFoodShop_CONNECTION";
    }

    public Food2DoorItem itemNoMapper(Food2DoorItem itemByF2D) {
        String itemByEFS = "EFS_" +itemByF2D.getItemNo();
        System.out.format("Mapping items for supplier EFS : %s -> %s\n", itemByF2D.getItemNo(), itemByEFS);
        return new Food2DoorItem(itemByEFS, itemByF2D.getItemName(), ItemType.SupplierItem );
    }
}
