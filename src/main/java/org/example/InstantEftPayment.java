package org.example;

public class InstantEftPayment implements PaymentMethod{
    @Override
    public PaymentResult pay(double amount) {
        return null;
    }

    @Override
    public String getDisplayName() {
        return "";
    }
}
