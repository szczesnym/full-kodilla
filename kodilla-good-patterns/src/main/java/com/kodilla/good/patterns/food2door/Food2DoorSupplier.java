package com.kodilla.good.patterns.food2door;

abstract public class Food2DoorSupplier implements Food2DoorProcessor {
    private String supplierName;
    private String connection;

    public Food2DoorSupplier(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getConnection() {
        return connection;
    }

    public Food2DoorSupplier(String supplierName, String connection) {
        this.supplierName = supplierName;
        this.connection = connection;
    }

    public boolean orderAvaiabilty (Food2DoorOrder order) {
        Food2DoorOrder orderByVendor;

        if(order.getOrderItem().getItemType() == ItemType.F2DItem) {
            orderByVendor = new Food2DoorOrder(this.itemNoMapper(order.getOrderItem()), order.getOrderQuantity());
        } else {
            orderByVendor = order;
        }
        return checkOrderByVendor(orderByVendor);
    }

    private boolean checkOrderByVendor(Food2DoorOrder orderByVendor) {
        this.connection = this.connectToSupplier();
        if(this.connection.isEmpty()) {
            return false;
        } else {
            //physical check by vendor
        }
        return true;
    }
}

