package org.example.Lab2InterfacePaymentSystem;

import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod{
    @Override
    public PaymentResult pay(BigDecimal amount) {
        return null;
    }

    @Override
    public String getDisplayName() {
        return "";
    }
}
