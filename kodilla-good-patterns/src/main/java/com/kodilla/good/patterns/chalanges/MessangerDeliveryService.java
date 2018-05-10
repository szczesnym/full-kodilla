package com.kodilla.good.patterns.chalanges;

public class MessangerDeliveryService implements DeliveryService{
    private final double deliveryCostPerOrder;

    public MessangerDeliveryService(String messengerType) {
        switch(messengerType) {
            case "DHL":  {
                this.deliveryCostPerOrder = 1.5;
                break;
            }
            case "UPS" : {
                this.deliveryCostPerOrder = 2.7;
                break;
            }
            default : {
                this.deliveryCostPerOrder = 2.1;
            }
        }
    }

    @Override
    public double deliveryCost(Order order) {
        return order.orderValue() * 0.01 * this.deliveryCostPerOrder;
    }
}
