package org.example;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{
    private BigDecimal cardBalance;
    private String cardHolder;
    private StringBuilder reference;
    private static int paymentNum = 0;

    public CardPayment(String owner, BigDecimal balance){
        cardHolder = owner;
        cardBalance = balance;
    }


    @Override
    public PaymentResult pay(BigDecimal amount){
        if (isAmountValid(amount)){
            if (cardBalance.compareTo(amount) >= 0){
                cardBalance = cardBalance.subtract(amount);
                CardPayment.paymentNum += 1;
                reference = new StringBuilder("CDP").append("-").append(cardHolder.replace(" ","_")).append("-").append(paymentNum);
                return new PaymentResult(true,reference.toString(),"Successfully made a card payment of R"+amount);
            }
            System.out.println("\nCard payment unsuccessful! card balance is insufficient.");
        }
        return new PaymentResult(false,"CDPFailed","Failed to make a card payment of R"+amount);
    }

    @Override
    public String getDisplayName() {
        return cardHolder;
    }
}
