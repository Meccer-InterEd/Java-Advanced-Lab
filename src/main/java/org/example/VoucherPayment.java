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
            throw new RuntimeException("You have insufficient funds to complete this transaction.");
        }
        voucherAmount -= amount;
        return new PaymentResult(true, "VOUCHER-Transaction", "Withdrew:R" + amount + "\n Remaining Balance:R" + voucherAmount);

    }

    @Override
    public String getDisplayName() {

        if(voucherAmount <= 0){
            return "Voucher Code " + voucherCode + " , has been completely used up";
        }else {
            return "Voucher Code " + voucherCode + " , has R" + voucherAmount + " remaining";
        }
    }
}
