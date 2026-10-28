package org.example;

import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod {

    @Override
    public PaymentResult pay(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return new PaymentResult(
                    false,
                    "EFT-1001",
                    "Failed: Payment amount must be greater than zero"
            );
        }

        return new PaymentResult(
                true,
                "EFT-1001",
                "Instant EFT payment successful"
        );
    }

    @Override
    public String getDisplayName() {
        return "Instant EFT Payment";
    }
}