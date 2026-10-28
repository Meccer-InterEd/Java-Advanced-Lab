package org.example.Lab2InterfacePaymentSystem;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod {
    private BigDecimal voucherBalance;
    PaymentResult pr = new PaymentResult(false,"moe","failed");


    public VoucherPayment( BigDecimal voucherBalance) {
        this.voucherBalance = voucherBalance;


    }

    @Override
    public PaymentResult pay(BigDecimal amount) {

        if (amount.compareTo(voucherBalance) > 0) {
            pr = new PaymentResult(false, "Invalid Voucher", "Voucher Rejected due to Insufficient balance.");
            return pr;
        }

        this.voucherBalance = this.voucherBalance.subtract(amount);
        pr = new PaymentResult(true, "Voucher-98", "Voucher has been applied successfully.");
        return pr;
    }

    @Override
    public String getDisplayName() {
        return " Voucher Payment Method";
    }

    @Override
    public String summary() {
        return "Payment Successful? " + pr.successful() + "\nReference - " + pr.reference() + "\nOutput - " + pr.message() ;
    }
}
