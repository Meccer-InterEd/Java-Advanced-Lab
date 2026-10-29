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

        /*
        CheckoutService checkoutService = new CheckoutService();

        checkoutService.checkout(new CardPayment(), new BigDecimal(1000));
        checkoutService.checkout(new InstantEftPayment(), new BigDecimal(340));
        checkoutService.checkout(new VoucherPayment(new BigDecimal(600)), new BigDecimal(543.50));

         */

        /*
        Lab 2 Questions:

        1. Why is PaymentMethod an interface?
           PaymentMethod is an interface because it defines a contract that all payment methods must follow without
           specifying how each payment method must work internally (each payment method will provide its own
           implementations of the methods found in the interface)

        2. What would happen if a new MobileWalletPayment class was added?
           The MobileWalletPayment would implement the PaymentMethod interface and work as part of the system just as
           the other payment methods do except it would have its own implementations of the different payment methods

        3. Which class should be responsible for checking that the amount is positive?
           The CheckoutMethod class should be responsible for checking that the amount is positive before
           passing it to the payment method

        4. Why should the checkout service depend on the interface instead of CardPayment?
           The CheckoutService must depend on the interface because it needs to work with different payment methods
           without being tied to one specific payment methods implementation
         */

        //Lab 3


        }

    }
