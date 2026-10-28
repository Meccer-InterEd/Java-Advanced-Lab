package org.example.payment;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{
    private BigDecimal balance;

    CardPayment(BigDecimal balance){
        if (balance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance = balance;
    }


    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        PaymentResult result;
        if (this.balance.compareTo(amount) >= 0){
            this.balance = balance.subtract(amount);
            result = new PaymentResult(true, "Card Payment", "successful");
            return result;
        }
        return new PaymentResult(false, "Card Payment", "Insufficient funds");
    }

    @Override
    public String getDisplayName() {
        return "Card Payment";
    }
}
