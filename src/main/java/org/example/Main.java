package org.example;

public class Main {
    public static void main(String[] args) {

        /*Order order = new Order("23-NUM-16", "Sydney", 10.00, DeliveryMethod.COLLECTION);

        order.display();
        order.confirmOrder(7.00);
        order.nextStatus();*/

        Order order1 = new Order("40-NUM-5", "Syd", 100.00, DeliveryMethod.STANDARD_DELIVERY);

        order1.display();
        order1.confirmOrder(1070.00);
        order1.nextStatus();
        order1.nextStatus();
        order1.nextStatus();

    }
}