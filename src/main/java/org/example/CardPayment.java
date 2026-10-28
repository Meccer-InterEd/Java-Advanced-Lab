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
            throw new RuntimeException("You have insufficient funds to complete this transaction.");
        }
        cardBalance -= amount;
        return new PaymentResult(true, "CARD-Transaction", "Withdrew:R" + amount + "\n Remaining Balance:R" + cardBalance);
    }

    @Override
    public String getDisplayName() {
        return bankName + " Card Transaction successful!";
    }
}
