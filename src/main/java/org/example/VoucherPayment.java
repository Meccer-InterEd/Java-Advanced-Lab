package org.example;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{
    private String voucherHolder;
    private BigDecimal voucherBalance;
    private StringBuilder reference;
    private static int paymentNum = 0;

    public VoucherPayment(String holder, BigDecimal balance){
        this.voucherHolder = holder;
        this.voucherBalance = balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (isAmountValid(amount)){
            if (voucherBalance.compareTo(amount) >= 0){
                voucherBalance = voucherBalance.subtract(amount);
                VoucherPayment.paymentNum += 1;
                reference = new StringBuilder("VCH").append("-").append(voucherHolder.replace(" ","_")).append("-").append(paymentNum);
                return new PaymentResult(true,reference.toString(),"Successfully made an voucher payment R"+amount);
            }
            System.out.println("\nVoucher payment unsuccessful! voucher balance is insufficient.");
        }
        return new PaymentResult(false,"VCHFailed","Failed to make an voucher payment of R"+amount);
    }

    @Override
    public String getDisplayName() {
        return voucherHolder;
    }
}
