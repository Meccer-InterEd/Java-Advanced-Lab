package org.example.Lab02_Interface_Payment_System;

import java.math.BigDecimal;
import java.util.UUID;

public class VoucherPayment implements PaymentMethod    {
    BigDecimal balance;
    PaymentResult paymentResult;
    @Override
    public PaymentResult pay(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return new PaymentResult(
                    false,
                    "",
                    "Invalid payment amount."
            );
        }

        String reference = "VOUCHER-" + UUID.randomUUID();

        return new PaymentResult(
                true,
                reference,
                "Store voucher payment completed successfully."
        );
    }


    @Override
    public String getDisplayName() {
        return "Voucher Payment";
    }
}