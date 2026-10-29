package org.example;

import java.math.BigDecimal;

public class CheckoutService {

    public PaymentResult checkout(PaymentMethod paymentMethod, BigDecimal amount) {
        // Validate amount, then delegate to the payment method.
        // Return the payment result.
        return paymentMethod.pay(amount);
    }
}
