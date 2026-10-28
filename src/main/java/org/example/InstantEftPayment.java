package org.example;

public class InstantEftPayment implements PaymentMethod{

    @Override
    public PaymentResult pay(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Amount can not be a negative or a zero");
        }
        return new PaymentResult(true, "EFT_01234567", "Your EFT payment has been authorized");
    }

    @Override
    public String getDisplayName() {
        return "EFT Payment";
    }
}
