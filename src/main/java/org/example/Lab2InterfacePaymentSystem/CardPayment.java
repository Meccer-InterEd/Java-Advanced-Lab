package org.example.Lab2InterfacePaymentSystem;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
    private BigDecimal cardBalance;
    PaymentResult pt = new PaymentResult(false,"Mo","failed");

    public CardPayment(BigDecimal cardBalance) {
        this.cardBalance = cardBalance;

    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (this.cardBalance.compareTo(amount) >= 0) {
            this.cardBalance = this.cardBalance.subtract(amount);
            pt = new PaymentResult(true, "CRDPayment", "Card Payment Successful");
            return pt;
        }
        pt = new PaymentResult(false, "CRP-F", "Card Payment Failed");
        return pt;
    }

    @Override
    public String getDisplayName() {
        return " Card Payment " ;
    }

    @Override
    public String summary() {
        return "Payment Successful? " + pt.successful() + "\nReference - " + pt.reference() + "\nOutput - " + pt.message() ;
    }
}
