package lab2.classes;

import lab2.interfaces.PaymentMethod;
import lab2.records.PaymentResult;

public class VoucherPayment implements PaymentMethod {

    private double balance;

    public VoucherPayment(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public PaymentResult pay(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return new PaymentResult(false,"N/A","Invalid amount");

        }

        return new PaymentResult(true,"Voucher Payment","Valid amount");

    }

    @Override
    public String displayName() {
        return "Voucher Payment";
    }
}
