package lab2.classes;

import lab2.interfaces.PaymentMethod;
import lab2.records.PaymentResult;

public class CardPayment implements PaymentMethod {

    private String cardNumber;

    public CardPayment() {
        this.cardNumber = "No Card Number";
    }

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    //Accept Cards Strating with Zero
    @Override
    public PaymentResult pay(double amount) {

       if ( cardNumber != null && !cardNumber.isBlank() && cardNumber.charAt(0) == '0' )
       {

           return new PaymentResult(true,"Card Payment","Valid Card Number");

       }

        return new PaymentResult(false,"Card Payment","Invalid Card Number");


    }



    @Override
    public String displayName() {
        return "Credit/Debit Card";
    }
}
