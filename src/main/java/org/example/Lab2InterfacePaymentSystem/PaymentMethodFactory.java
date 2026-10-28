package org.example.Lab2InterfacePaymentSystem;

import javax.lang.model.type.NullType;
import java.math.BigDecimal;

public class PaymentMethodFactory {


    public PaymentMethod determinePayMethod(PaymentType type, BigDecimal amount) {

        if (type == null) {
            throw new IllegalArgumentException("Payment Type cannot be empty");
        }
        PaymentMethod pm = null;
        switch (type) {
            case CARD:
                pm = new CardPayment(amount);
                break;
            case VOUCHER:
                pm = new VoucherPayment(amount);
                break;
            case INSTANT_EFT:
                pm = new InstantEftPayment(amount);
                break;
            default:
                throw new IllegalArgumentException("Unknown Payment type" + type);
        }

        return pm;
    }
}
