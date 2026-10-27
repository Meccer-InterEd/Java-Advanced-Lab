package org.example;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod {
    private double voucherBalance = 200.00;

    @Override
    public PaymentResult pay(double amount) {
        if(amount > voucherBalance ){
            throw new IllegalArgumentException("Amount can not be more than available voucher balance");
        }
        System.out.println("Voucher Balance: R" + voucherBalance);
        return new PaymentResult(true, "5449000", "Your voucher payment has been authorized");

    }


    @Override
    public String getDisplayName() {
        return "Voucher";
    }
}

