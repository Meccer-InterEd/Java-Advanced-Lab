package org.example;

public class CardPayment implements PaymentMethod{

    @Override
    public PaymentResult pay(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Amount can not be a negative or a zero");
        }
        return new PaymentResult(true, "CARD_0053 2324", "Your voucher payment has been authorized");
    }

    @Override
    public String getDisplayName() {
        return "Card Payment";
    }
}
