package za.co.mie;

import java.math.BigDecimal;

public class PaymentMethodFactory {
    public static PaymentMethod create(PaymentType type) {
        return switch (type) {
            case CARD -> new CardPayment(new BigDecimal("5000"));
            case INSTANT_EFT -> new InstantEftPayment();
            case VOUCHER -> new VoucherPayment(new BigDecimal("200"));
        };
    }
}
