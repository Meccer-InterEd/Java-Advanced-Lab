package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("ORD-1001", "Lerato", new BigDecimal("249.99"), new BigDecimal("400") ,DeliveryMethod.STANDARD_DELIVERY);
        Order order2 = new Order("ORD-2001", "Andile", new BigDecimal("349.99"), new BigDecimal("200"),DeliveryMethod.COLLECTION);
        Order order3 = new Order("ORD-3001", "Tshepo", new BigDecimal("449.99"), new BigDecimal("700"),DeliveryMethod.EXPRESS_DELIVERY);
        order1.info();
        order1.totalCost();
        order2.info();
        order2.totalCost();
        order3.info();
        order3.totalCost();
        }
    }
