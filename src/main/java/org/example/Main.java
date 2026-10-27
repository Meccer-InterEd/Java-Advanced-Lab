package org.example;

public class Main {
    public static void main(String[] args) {

        Order order = new Order("23-NUM-16", "Sydney", 10.00, DeliveryMethod.COLLECTION);

        order.display();

    }
}