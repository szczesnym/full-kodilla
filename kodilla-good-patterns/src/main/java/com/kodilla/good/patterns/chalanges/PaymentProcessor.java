package com.kodilla.good.patterns.chalanges;

public class PaymentProcessor {
    private Order order;
    private DeliveryService deliveryService;
    private Payment payment;

    public PaymentProcessor(Order order, DeliveryService deliveryService, Payment payment) {
        this.order = order;
        this.deliveryService = deliveryService;
        this.payment = payment;
    }

    public boolean makePayment() {
        double orderValue = order.orderValue();
        double deliveryValue = deliveryService.deliveryCost(order);

        System.out.format("Value of order:%f, delivery costs:%f\n", orderValue, deliveryValue);
        return this.payment.pay(orderValue + deliveryValue);
    }
}
