package org.example;

public interface PaymentMethod {
    PaymentResult pay(double amount);
    String getDisplayName();
}
