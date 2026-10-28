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
            throw new RuntimeException("You have insufficient funds to complete this transaction.");
        }
        eftBalance -= amount;
        return new PaymentResult(true, "EFT-Transaction", "Withdrew:R" + amount + "\n Remaining Balance:R" + eftBalance);
    }

    @Override
    public String getDisplayName() {

        return bankName + " EFT successful!";
    }
}
