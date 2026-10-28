package org.example.payment;

import java.math.BigDecimal;

public class InstanceEftPayment implements PaymentMethod{
    private BigDecimal balance;

    InstanceEftPayment(BigDecimal balance){
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
            result = new PaymentResult(true, "Instance EFT Payment", "successful");
            return result;
        }
        return new PaymentResult(false, "Instance EFT Payment", "Insufficient funds");
    }

    @Override
    public String getDisplayName() {
        return "Instance payment";
    }
}
