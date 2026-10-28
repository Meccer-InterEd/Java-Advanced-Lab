package org.example;

public class CardPayment implements PaymentMethod{

    String bankName;
    double cardBalance;


    CardPayment(String bankName, double cardBalance){

        this.bankName = bankName;
        this.cardBalance = cardBalance;
    }


    @Override
    public PaymentResult pay(double amount) {

        if(cardBalance < amount){
            throw new RuntimeException("The amount due cannot be zero or less");
        }
        cardBalance -= amount;
        return new PaymentResult(true, "CARD-Transaction", "PAID : R" + amount + "\nRemaining Balance : R" + cardBalance);
    }

    @Override
    public String getDisplayName() {
        return bankName + " Card Transaction successful!";
    }
}
