package org.example;

import static org.example.DeliveryMethod.*;
import static org.example.PaymentStatus.*;

public class Main {

    public static void main(String[] args) {

        Order order = new Order("0000000001", "Siyabonga", 180.22, PAID, COLLECTION);

        double deliveryFee = switch (order.getDeliveryMethod()) {
            case EXPRESS_DELIVERY -> order.getTotalAmount() * 0.15;
            case STANDARD_DELIVERY -> order.getTotalAmount() * 0.10;
            case COLLECTION -> 0.0;
        };
        System.out.printf("Delivery fee is: R%.2f", deliveryFee);
    }
}