package org.example.Lab02_Interface_Payment_System;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class CardPayment implements PaymentMethod {
    BigDecimal balance = new BigDecimal("1000.00");
    public String generateCardReference() {

        String date = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
        );

        String uniqueId = UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();

        return "CARD-" + date + "-" + uniqueId;
    }
    @Override
    public PaymentResult pay(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return new PaymentResult(
                    false,
                    "",
                    "Invalid payment amount."
            );
        }

        String reference =generateCardReference();

        return new PaymentResult(
                true,
                reference,
                "Card payment completed successfully."
        );
    }

    @Override
    public String getDisplayName() {
        return "Card Payment ";
    }
}
