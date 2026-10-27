package org.example.payment;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{
    @Override
    public PaymentResult pay(BigDecimal amount) {
        return null;
    }

    @Override
    public String getDisplayName() {
        return "";
    }
}
