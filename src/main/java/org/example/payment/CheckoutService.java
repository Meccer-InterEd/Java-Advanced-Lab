package org.example.payment;

import java.math.BigDecimal;

public class CheckoutService {
    public PaymentResult checkout(
            PaymentMethod paymentMethod,
            BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        return paymentMethod.pay(amount);
    }
}
