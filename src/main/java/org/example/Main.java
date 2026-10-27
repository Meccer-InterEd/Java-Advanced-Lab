package org.example;

import org.example.food_delivery.DeliveryMethod;
import org.example.food_delivery.Order;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(
                "ORD-1001",
                "Lerato",
                new BigDecimal("249.99"),
                DeliveryMethod.STANDARD_DELIVERY
        );
        order.pay(new BigDecimal("350"));
        order.displayDetails();
        order.updateStatus();
        order.updateStatus();
        order.updateStatus();
        order.updateStatus();
    }
    }
