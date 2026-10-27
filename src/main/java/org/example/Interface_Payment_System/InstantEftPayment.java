package org.example.Interface_Payment_System;

import java.math.BigDecimal;
import java.math.BigInteger;

public class InstantEftPayment implements PaymentMethod{
    private BigDecimal balance = new BigDecimal("2000.00");
 PaymentResult paymentResult;
    @Override
    public PaymentResult pay(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return new PaymentResult(
                    false,
                    "EFT-001",
                    "Invalid payment amount."
            );
        }

        if (amount.compareTo(balance) > 0) {
            return new PaymentResult(
                    false,
                    "EFT-001",
                    "Payment failed. Insufficient balance."
            );
        }

        balance = balance.subtract(amount);

        return new PaymentResult(
                true,
                "EFT-001",
                "Instant EFT payment successful."
        );
    }


    @Override
    public String getDisplayName() {
        return "Instant EFT Payment";
    }
}
