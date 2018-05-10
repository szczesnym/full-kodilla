package com.kodilla.good.patterns.chalanges;

public class ItemOrder extends Order {
    private String itemCode;
    private String itemName;

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public ItemOrder(double quantity, double pricePerUnit, String itemCode, String itemName) {
        super(quantity, pricePerUnit);
        this.itemCode = itemCode;
        this.itemName = itemName;
    }
}
