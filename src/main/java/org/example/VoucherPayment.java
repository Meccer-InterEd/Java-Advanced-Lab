package org.example;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod {
    private BigDecimal balance;

    public VoucherPayment(BigDecimal _balance) {
        this.balance = _balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if  (amount.compareTo(balance) > 0) {
            return new PaymentResult(
                    false,
                    "VP-1001",
                    "Insufficient voucher funds"
            );
        }
        balance = balance.subtract(amount);
        return new PaymentResult(
                true,
                "VP-1002",
                "Voucher payment successful!!"
        );
    }

    @Override
    public String getDisplayName() {
        return "Voucher Payment.";
    }
}
