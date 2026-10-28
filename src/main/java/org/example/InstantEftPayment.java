package org.example;

import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod{

    @Override
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(
                true,
                "EFT-1001",
                "EFT payment was SUCCESSFUL!!"
        );
    }

    @Override
    public String getDisplayName() {
        return "Instant EFT Payment.";
    }
}
