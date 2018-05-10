package com.kodilla.good.patterns.chalanges;

public class Application {

    public static void main(String[] args) {

        ItemOrder testOrder1 = new ItemOrder(10.0, 7.5, "Shoes_111", "Running shoes");
        ServiceOrder testOrder2 = new ServiceOrder(1.0, 4.5, "Mechanical services");
        ServiceOrder testOrder3 = new ServiceOrder(1.0, 79, "IT services");
        Payment testPaymentMethod1 = new TransferPayment();
        Payment testPaymentMethod2 = new OnDeliveryPayment();
        Payment testPaymentMethod3 = new OnDeliveryPayment();
        DeliveryService testDeliveryService1 = new MessangerDeliveryService("DHL");
        DeliveryService testDeliveryService2 = new PostDeliveryService(1.7);
        DeliveryService testDeliveryService3 = new PostDeliveryService(2);
        PaymentProcessor testPayment1 = new PaymentProcessor(testOrder1, testDeliveryService1, testPaymentMethod1);
        PaymentProcessor testPayment2 = new PaymentProcessor(testOrder2, testDeliveryService2, testPaymentMethod2);
        PaymentProcessor testPayment3 = new PaymentProcessor(testOrder3, testDeliveryService3, testPaymentMethod3);

        boolean order1Result = testPayment1.makePayment();
        System.out.format("Order 1, ordered with status :%b\n", order1Result);
        boolean order2Result = testPayment2.makePayment();
        System.out.format("Order 2, ordered with status :%b\n", order2Result);
        boolean order3Result = testPayment3.makePayment();
        System.out.format("Order 3, ordered with status :%b\n", order3Result);

    }
}
