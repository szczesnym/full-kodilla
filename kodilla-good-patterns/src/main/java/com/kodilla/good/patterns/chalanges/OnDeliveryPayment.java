package com.kodilla.good.patterns.chalanges;

public class OnDeliveryPayment implements Payment {

    @Override
    public boolean pay(double amount) {

        System.out.format("OnDelivery payment of:%f\n", amount);
        return true;
    }
}
