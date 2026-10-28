package org.example;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{

    private BigDecimal balance;

    public CardPayment(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (amount.compareTo(balance) > 0) {
            return new PaymentResult(
                    false,
                    "CP-1001",
                    "Failed: Insufficient Card balance"
            );
        }

        balance = balance.subtract(amount);

        return new PaymentResult(
                true,
                "CP-1001",
                "Card payment successful"
        );
    }

    @Override
    public String getDisplayName() {
        return "Card Payment";
    }
}
