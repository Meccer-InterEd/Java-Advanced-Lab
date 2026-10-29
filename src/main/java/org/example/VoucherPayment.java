package org.example;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{

    private BigDecimal voucherBalance;

    VoucherPayment(BigDecimal voucherBalance) {
        this.voucherBalance = voucherBalance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        if (amount.compareTo(voucherBalance) > 0) {
            return new PaymentResult(false, "VOUCHER", "Voucher cannot cover the cost");
        }

        voucherBalance = voucherBalance.subtract(amount);

        return new PaymentResult(true, "VOUCHER_908", "Voucher payment successful");
    }

    public String getDisplayName() {
        return "Voucher Payment";
    }

}
