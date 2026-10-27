package org.example;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod {

    private BigDecimal balance;

    public VoucherPayment(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {

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
    void displayVoucher(){

    }
}
