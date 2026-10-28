package org.example;

import java.math.BigDecimal;

public class CheckoutService {

    public PaymentResult checkout(PaymentMethod paymentMethod, BigDecimal amount) {
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
        PaymentResult result = paymentMethod.pay(amount);
        System.out.println("Payment Method: " + paymentMethod.getDisplayName());
        System.out.println("Successful: " + result.successful());
        System.out.println("Message: " + result.message());
        System.out.println("Reference: " + result.reference());

        return result;
    }
}
