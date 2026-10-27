package org.example.Interface_Payment_System;

import java.math.BigDecimal;

public class CheckoutService {
    public PaymentResult checkout(
            PaymentMethod paymentMethod,
            BigDecimal amount) {
        // Validate amount, then delegate to the payment method.
        // Return the payment result.
        throw new UnsupportedOperationException("Implement this");
    }
}
