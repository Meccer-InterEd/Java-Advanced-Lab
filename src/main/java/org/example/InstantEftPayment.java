package org.example;

public class InstantEftPayment implements PaymentMethod{

    String bankName;
    double eftBalance;

    InstantEftPayment(String bankName, double eftBalance){

        this.bankName = bankName;
        this.eftBalance = eftBalance;
    }

    @Override
    public PaymentResult pay(double amount) {

        if(eftBalance < amount){
            throw new RuntimeException("The amount due cannot be zero or less");
        }
        eftBalance -= amount;
        return new PaymentResult(true, "EFT-Transaction", "PAID : R" + amount + "\nRemaining Balance : R" + eftBalance);
    }

    @Override
    public String getDisplayName() {

        return bankName + " EFT successful!";
    }
}
