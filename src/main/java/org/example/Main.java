package org.example;


import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Do good and be productive!!");
        }
    Order order = new Order("ORD-1001", "Lerato", "249.99",OrderStatus.PLACED, PaymentStatus.PENDING, DeliveryMethod.STANDARD_DELIVERY);

}

