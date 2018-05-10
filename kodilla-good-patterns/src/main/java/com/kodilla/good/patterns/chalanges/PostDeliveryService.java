package com.kodilla.good.patterns.chalanges;

public class PostDeliveryService implements DeliveryService {
    final double postDeliveryCost;

    public PostDeliveryService(double postCost) {
        this.postDeliveryCost = postCost;
    }

    @Override
    public double deliveryCost(Order order) {

        if (order instanceof ServiceOrder) {
            return this.postDeliveryCost;
        }
        if (order instanceof ItemOrder) {
            return this.postDeliveryCost * order.getQuantity();
        }
        return 0;
    }
}
