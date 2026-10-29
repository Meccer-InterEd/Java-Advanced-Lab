package org.example;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{
    private BigDecimal voucherBalance;
    private boolean didPaymentSucceed;

    VoucherPayment(BigDecimal voucherBalance){
        this.voucherBalance = voucherBalance;
        didPaymentSucceed = false;
    }

    @Override
    public PaymentResult pay(BigDecimal amountOwed) {
        if (amountOwed.doubleValue() > voucherBalance.doubleValue()){
            return new PaymentResult(false,"VCH-Failed", "Insufficient funds") ;
        } else {
            voucherBalance = voucherBalance.subtract(amountOwed);
            didPaymentSucceed = true;
            return  new PaymentResult(true,"VCH-Success","Your voucher payment succeeded");
        }
    }

    @Override
    public String getDisplayName() {
        return didPaymentSucceed ? "\nPayment Type: Voucher | Reference: VCH-Success" : "\nPayment Type: Voucher | Reference: VCH-Failed";
    }
}
