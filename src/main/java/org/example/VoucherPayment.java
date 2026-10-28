package org.example;

public class VoucherPayment implements PaymentMethod {

    String voucherCode;
    double voucherAmount;

    VoucherPayment(String voucherCode, double voucherAmount){

        this.voucherCode = voucherCode;
        this.voucherAmount = voucherAmount;
    }

    @Override
    public PaymentResult pay(double amount) {


        if(voucherAmount < amount){
            throw new RuntimeException("The amount due cannot be zero or less");
        }
        voucherAmount -= amount;
        return new PaymentResult(true, "VOUCHER-Transaction", "PAID : R" + amount + "\nRemaining Balance : R" + voucherAmount);
    }

    @Override
    public String getDisplayName() {

        if(voucherAmount <= 0){
            return "Voucher Code " + voucherCode + " has been fully redeemed";
        }else {
            return "Voucher Code " + voucherCode + " , has R" + voucherAmount + " remaining";
        }
    }
}
