package org.example.PaymentSystem;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{

    String cardNumber;
    String accountHolder;
    BigDecimal balance;


    CardPayment(String cardNumber, String accountHolder,BigDecimal balance){
        this.cardNumber = cardNumber;
        this.accountHolder = accountHolder;
        this.balance= balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (balance.doubleValue() < amount.doubleValue()) {
            return new PaymentResult(false, this.cardNumber, "Card Number :" + this.cardNumber + " has failed");
        } else {
            return new PaymentResult(true, this.cardNumber, "Transcation ID :" + this.cardNumber + " is successful");
        }

    }

    @Override
    public String getDisplayName() {
        return this.accountHolder;
    }
}
