package org.example;

public class VoucherPayment implements PaymentMethod{
    private double voucherBalance = 20.22;

    @Override
    public PaymentResult pay(double amount) {
        if(amount >= voucherBalance){
            throw new IllegalArgumentException("The amount cant be greater than the voucher balance");
        }
        return new PaymentResult(true,"v001","Voucher payment successful");
    }

    @Override
    public String getDisplayName() {
        return "Voucher";
    }
}
