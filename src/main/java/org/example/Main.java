package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        //Lab 1:

        /*
        Order order1 = new Order(101, "Makwa", 350.50,
                OrderStatus.PLACED, PaymentStatus.PENDING, DeliveryMethod.EXPRESS_DELIVERY);

        Order order2 = new Order(102, "Lona", 300,
                OrderStatus.OUT_FOR_DELIVERY, PaymentStatus.PAID, DeliveryMethod.STANDARD_DELIVERY);

        Order order3 = new Order(103, "Siya", 750.75,
                OrderStatus.READY_FOR_COLLECTION, PaymentStatus.PAID, DeliveryMethod.COLLECTION);

        order1.makePayment();
        order1.confirmOrder();
        order1.displayOrderSummary();
        order1.updateStatus();
        order1.displayOrderSummary();

        order2.displayOrderSummary();
        order2.updateStatus();
        order2.cancelOrder();

        order3.displayOrderSummary();

        order1.cancelOrder();
        order1.displayOrderSummary();
        order1.updateStatus();

         */

        //Lab 2:

        CheckoutService checkoutService = new CheckoutService();

        checkoutService.checkout(new CardPayment(), new BigDecimal(1000));
        checkoutService.checkout(new InstantEftPayment(), new BigDecimal(340));
        checkoutService.checkout(new VoucherPayment(new BigDecimal(600)), new BigDecimal(543.50));

        }

    }
