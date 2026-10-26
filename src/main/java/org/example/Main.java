package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            Order order = new Order(
                    "ORD-1001",
                    "Lerato",
                    new BigDecimal("249.99"),
                    DeliveryMethod.STANDARD_DELIVERY
            );
            order.Pay(new BigDecimal("290.00"));
        }
    }
