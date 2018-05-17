package com.kodilla.good.patterns.food2door;

public class Food2DoorItem {
    private String itemNo;
    private String itemName;
    private ItemType itemType;

    public Food2DoorItem(String itemNo, String itemName, ItemType itemType) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemType = itemType;
    }

    public String getItemNo() {
        return itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
