package org.example;

public class InstantEftPayment implements PaymentMethod{
    @Override
    public PaymentResult pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be zero or negative. Provided: R" + amount);
        }
        return new PaymentResult(true,"EFT_01234567","Instant EFT payment authorized successfully.");
    }

    @Override
    public String getDisplayName() {
        return "Instant EFT Payment";
    }
}
