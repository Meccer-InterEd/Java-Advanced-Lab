package org.example;

public class CardPayment implements PaymentMethod {

    @Override
    public PaymentResult pay(double amount) {
            if(amount <= 0){
                throw new IllegalArgumentException("The amount cant be less than zero!!");
            }
            return new PaymentResult(false,"card113","Your card payment has failed");
        }
        @Override
        public String getDisplayName() {
            return "Card Payment";
        }
}
