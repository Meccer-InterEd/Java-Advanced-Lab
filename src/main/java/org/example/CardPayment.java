package org.example;

public class CardPayment implements PaymentMethod {
    @Override
    public PaymentResult pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be zero or negative. Provided: R" + amount);
        }
        return new PaymentResult(true,"CARD_0053 2324","Card payment authorized successfully.");
    }

    @Override
    public String getDisplayName() {
        return "Card Payment";
    }
}
