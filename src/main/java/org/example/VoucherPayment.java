package org.example;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod {

    private BigDecimal balance;

    public VoucherPayment(BigDecimal balance) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Voucher balance cannot be null or negative"
            );
        }

        this.balance = balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return new PaymentResult(
                    false,
                    "VC-1001",
                    "Failed: Payment amount must be greater than zero"
            );
        }

        if (amount.compareTo(balance) > 0) {
            return new PaymentResult(
                    false,
                    "VC-1001",
                    "Failed: Insufficient voucher balance"
            );
        }

        balance = balance.subtract(amount);

        return new PaymentResult(
                true,
                "VC-1001",
                "Voucher payment successful"
        );
    }

    @Override
    public String getDisplayName() {
        return "Voucher Payment";
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void displayVoucher() {
        System.out.println("Voucher Balance: R" + balance);
    }
}
