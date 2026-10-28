package org.example;

public class InstantEftPayment implements PaymentMethod{
    @Override
    public PaymentResult pay(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("The amount cant be less than zero!!");
        }
        return new PaymentResult(false,"eft111","Your eft payment has failed");
    }

    @Override
    public String getDisplayName() {
        return "Eft payment";
    }
}
