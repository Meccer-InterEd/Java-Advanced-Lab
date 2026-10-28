package org.example.Lab2;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{

    private static int counter = 100;

    @Override
    public PaymentResult pay(BigDecimal amount) {

        if (amount.compareTo(new BigDecimal("10000")) > 0) {

            return new PaymentResult(
                    false,
                    "null",
                    "Card payment declined.");
        }

        counter++;

        return new PaymentResult(
                true,
                "CARD-" + counter,
                "Card payment successful.");
    }

    @Override
    public String getDisplayName() {
        return "Card";
    }

}
