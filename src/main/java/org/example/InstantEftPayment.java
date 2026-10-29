package org.example;

import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod{

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amounts must be greater than 0");
        }

        return new PaymentResult(true, "EFT_342", "EFT payment successful");
    }

    @Override
    public String getDisplayName() {
        return "EFT Payment";
    }
}
