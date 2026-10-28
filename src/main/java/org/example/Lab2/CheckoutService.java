package org.example.Lab2;

import java.math.BigDecimal;

public class CheckoutService{

    public PaymentResult checkout(PaymentMethod method, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException("Amount must be above zero.");
        }

        PaymentResult result = method.pay(amount);

        System.out.println("Payment method: " + method.getDisplayName());
        System.out.println("Successful: " + result.successful());
        System.out.println("Message: " + result.message());
        System.out.println("Reference: " + result.reference());
        System.out.println("--------------------");


        return result;

    }



}
