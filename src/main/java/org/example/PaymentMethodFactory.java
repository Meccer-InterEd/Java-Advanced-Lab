package org.example;

import java.math.BigDecimal;

public class PaymentMethodFactory {
    public static PaymentMethod manufacturePaymentMethod(PaymentType paymentType, String holder, BigDecimal balance){
        if (paymentType.equals(PaymentType.CARD_PAYMENT)){
            return new CardPayment(holder,balance);
        } else if (paymentType.equals(PaymentType.INSTANT_EFT_PAYMENT)){
            return new InstantEftPayment(holder,balance);
        }
        return new VoucherPayment(holder,balance);
    }
}
