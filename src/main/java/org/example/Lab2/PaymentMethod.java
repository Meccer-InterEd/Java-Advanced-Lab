package org.example.Lab2;


import java.math.BigDecimal;

public interface PaymentMethod {
    PaymentResult pay(BigDecimal amount);
    String getDisplayName();
}
