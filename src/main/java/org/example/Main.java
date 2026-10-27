package org.example;

public class Main {
    public static void main(String[] args) {

        Order order = new Order("111", "Syd", 240, OrderStatus.PLACED, PaymentStatus.PENDING, DeliveryMethod.COLLECTION);


    }
}