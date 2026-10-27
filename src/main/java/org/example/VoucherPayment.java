package org.example;

public class VoucherPayment implements PaymentMethod{


    @Override
    public PaymentResult pay(double amount) {
        double voucherBalance = 200.00;
        if (amount > voucherBalance) {
            throw new IllegalArgumentException("Amount cannot be more than the available balance. Provided: R" + amount + " and the balance is: R" + voucherBalance);
        }
        return new PaymentResult(true,"VCH_212345","Voucher payment authorized successfully.");
    }

    @Override
    public String getDisplayName() {
        return "Voucher Payment";
    }
}
