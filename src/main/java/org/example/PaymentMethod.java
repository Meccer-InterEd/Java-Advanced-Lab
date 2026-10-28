package org.example;

import java.math.BigDecimal;

public interface PaymentMethod {
    PaymentResult pay(BigDecimal amount);
    //process a payment and returns the result.
    String getDisplayName();
    //returns the payment method's name
}
