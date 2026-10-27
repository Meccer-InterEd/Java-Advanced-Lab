package org.example.payment;

import java.math.BigDecimal;

public interface PaymentMethod {
    PaymentResult pay(BigDecimal amount);
    String getDisplayName();
}
