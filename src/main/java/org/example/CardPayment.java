package org.example;
//Each implementation must apply its own rules.
//For example, a voucher payment should reject an amount greater than the voucher balance.
//The card and EFT implementations can simulate success or failure; do not connect to real payment services.

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
    @Override
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(
                true,
                "CP-1001",
                "CARD PAYMENT WAS SUCCESSFUL!!"
        );
    }

    @Override
    public String getDisplayName() {
        return "Card Payment.";
    }
}
