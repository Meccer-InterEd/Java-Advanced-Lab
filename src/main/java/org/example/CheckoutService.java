package org.example;

import java.math.BigDecimal;

public class CheckoutService {
    public PaymentResult checkout(PaymentMethod paymentMethod, BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amounts must be greater than 0");
        }

        PaymentResult result = paymentMethod.pay(amount);

        System.out.println("PAYMENT RESULT");
        System.out.println("--------------------------------------");
        System.out.println("Payment type: " + paymentMethod.getDisplayName());
        System.out.println("Payment reference: " + result.reference());
        System.out.println("Payment amount: R" + amount);
        System.out.println("Payment success: " + result.successful());
        System.out.println("Message: " + result.message() + "\n");

        return result;
    }

}
