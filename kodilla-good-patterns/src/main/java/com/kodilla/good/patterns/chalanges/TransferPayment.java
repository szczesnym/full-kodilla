package com.kodilla.good.patterns.chalanges;

public class TransferPayment implements Payment {

    @Override
    public boolean pay(double amount) {

        System.out.format("Bank transfer payment of:%f\n", amount);
        return true;
    }
}