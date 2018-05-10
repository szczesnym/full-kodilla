package com.kodilla.good.patterns.chalanges;

public class ServiceOrder extends Order {
    private String serviceType;

    public ServiceOrder(double quantity, double pricePerUnit, String serviceType) {
        super(quantity, pricePerUnit);
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return this.serviceType;
    }
}