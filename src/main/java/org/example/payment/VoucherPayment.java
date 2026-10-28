package org.example.payment;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{
    private BigDecimal balance;

    public VoucherPayment(BigDecimal balance){
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
            result = new PaymentResult(true, "Voucher", "successful");
            return result;
        }
        result = new PaymentResult(false, "Voucher", " Insufficient voucher funds");

        return result;
    }

    @Override
    public String getDisplayName() {
        return "Voucher Payment";
    }
}
