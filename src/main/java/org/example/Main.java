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
            order.Pay(new BigDecimal("285.00"));
            order.cancelOrder();
            order.orderProgress();
//            order.orderSummary();

//            Order order2 = new Order(
//                    "ORD-1002",
//                    "Thato",
//                    new BigDecimal("260.00"),
//                    DeliveryMethod.COLLECTION
//            );
//            order2.Pay(new BigDecimal("290.00"));
        }
    }
