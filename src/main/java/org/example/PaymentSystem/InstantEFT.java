package org.example.PaymentSystem;

import java.math.BigDecimal;

public class InstantEFT implements PaymentMethod{
    String tansactionID;
    String senderName;
    BigDecimal accountBalance;

    InstantEFT(String transactionID, String senderName,  BigDecimal accountBalance){
        this.tansactionID = transactionID;
        this.senderName = senderName;
        this.accountBalance = accountBalance;

    }
    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (accountBalance.doubleValue() < amount.doubleValue()) {
            return new PaymentResult(false, this.tansactionID, "Transcation ID :" + this.tansactionID + " has failed");
        } else {
            return new PaymentResult(true, this.tansactionID, "Transcation ID :" + this.tansactionID + " is successful");
        }
    }
    @Override
    public String getDisplayName() {
        return this.senderName;
    }
}
