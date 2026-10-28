package org.example;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod {


    @Override
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(
                true,
                "VP-1001",
                "Voucher payment was Successful!!"
        );
    }

    @Override
    public String getDisplayName() {
        return "Voucher Payment.";
    }
}
