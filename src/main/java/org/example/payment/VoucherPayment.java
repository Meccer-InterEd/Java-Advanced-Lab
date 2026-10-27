package org.example.payment;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{
    private BigDecimal balance = new BigDecimal("500");

    @Override
    public PaymentResult pay(BigDecimal amount) {
        PaymentResult result;
        if (amount.compareTo(this.balance) >= 0){
            result = new PaymentResult(true, "Voucher", " Voucher payment successful");
            return result;
        }
        result = new PaymentResult(false, "Voucher", " Insufficient voucher balance");

        return result;
    }

    @Override
    public String getDisplayName() {
        return "Voucher";
    }
}
