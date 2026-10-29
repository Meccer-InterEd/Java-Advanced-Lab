package org.example;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amounts must be greater than 0");
        }

        return new PaymentResult(true, "CARD_001", "Card payment successful");
    }

    @Override
    public String getDisplayName() {
        return "Card Payment";
    }
}
