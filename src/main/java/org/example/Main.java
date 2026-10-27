package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            // Customer canceled order
            Order order = new Order(
                    "ORD-1001",
                    "Lerato",
                    new BigDecimal("249.99"),
                    DeliveryMethod.STANDARD_DELIVERY
            );
            order.Pay(new BigDecimal("295.00"));
            order.cancelOrder();
            order.orderProgress();

            //Order canceled due to non-payment
            Order order2 = new Order(
                    "ORD-1002",
                    "Thato",
                    new BigDecimal("260.00"),
                    DeliveryMethod.COLLECTION
            );
            order2.Pay(new BigDecimal("200.00"));

            // Successful delivery order
            Order order3 = new Order(
                    "ORD-1003",
                    "Thabo",
                    new BigDecimal("200.00"),
                    DeliveryMethod.EXPRESS_DELIVERY
            );
            order3.Pay(new BigDecimal("300.00"));
            order3.orderProgress();

        }
    }
