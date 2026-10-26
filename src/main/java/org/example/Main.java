package org.example;


//import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Do good and be productive!!");

        Order order = new Order(001, "Lerato", 249.99, DeliveryMethod.STANDARD_DELIVERY);

        Order order1 = new Order(111,"Lona",199.99, DeliveryMethod.COLLECTION);
        Order order2 = new Order(112,"Siya",1000, DeliveryMethod.EXPRESS_DELIVERY);

        order.displayDetails();

        order1.setPaymentStatus(PaymentStatus.PAID);
        order1.nextStatus();
        order1.nextStatus();
        order1.nextStatus();
        order1.displayDetails();

        order2.cancelOrder();
        order2.setPaymentStatus(PaymentStatus.FAILED);
        order2.displayDetails();






        }
    }
