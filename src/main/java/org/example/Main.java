package org.example;


import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Do good and be productive!!");

        Order order = new Order(
                1234,
                "Lerato",
                6373,
                DeliveryMethod.STANDARD_DELIVERY
        );
        order.setPaymentStatus(PaymentStatus.PAID);
        order.nextStatus();
        order.nextStatus();
        Order order1=new Order(111,"Lona",2000,DeliveryMethod.COLLECTION);
        Order order2=new Order(222,"Siya",5000,DeliveryMethod.COLLECTION);
        order.displayDetails();

        order1.displayDetails();
        order2.displayDetails();
        }
    }
