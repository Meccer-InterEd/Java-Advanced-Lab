package org.example.Lab2;

public interface PaymentMethod {
    PaymentResult pay();
    String getDisplayName();
}
