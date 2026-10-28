package org.example.PaymentSystem;

import java.math.BigDecimal;

public class InstantEFT implements PaymentMethod{
    @Override
    public PaymentResult pay(BigDecimal amount) {
        return null;
    }

    @Override
    public String getDisplayName() {
        return "";
    }
}
