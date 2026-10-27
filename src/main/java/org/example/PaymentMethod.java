package org.example;

import java.math.BigDecimal;

public interface PaymentMethod {
    PaymentResult pay(double amount);
    String getDisplayName(); // display the type of payment
}
