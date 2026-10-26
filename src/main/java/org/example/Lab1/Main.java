package org.example.Lab1;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(1001, "Lerato", 249.99, DeliveryMethod.EXPRESS_DELIVERY);
        order.displaySummary();

        order.paymentStatus(PaymentStatus.PAID);
        order.confirmOrder();
        order.displaySummary();
        order.nextStatus();
    }
}

