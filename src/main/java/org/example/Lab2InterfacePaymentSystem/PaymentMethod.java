package org.example.Lab2InterfacePaymentSystem;

import java.math.BigDecimal;

public interface PaymentMethod {
    PaymentResult pay(BigDecimal amount);
    String getDisplayName();
    String summary();
}
