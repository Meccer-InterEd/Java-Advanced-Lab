package org.example.Lab2InterfacePaymentSystem;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{
    private BigDecimal voucherBalance;
    String accHolder;


    public VoucherPayment(String accHolder,BigDecimal voucherBalance){
        this.voucherBalance = voucherBalance;
        this.accHolder = accHolder;

    }

    @Override
    public PaymentResult pay(BigDecimal amount) {

        if(amount.compareTo(voucherBalance) >0){
            return new PaymentResult(false,"Invalid","Voucher Rejected due to Insufficient balance.");
        }

        this.voucherBalance = this.voucherBalance.subtract(amount);
        return new PaymentResult(true,"Voucher-98","Voucher has been applied successfully.");
    }

    @Override
    public String getDisplayName() {
        return accHolder+ " Paid using the Voucher Payment Method";
    }
}
