package org.example;

import java.math.BigDecimal;

public class CardPayment implements  PaymentMethod {
    private BigDecimal cardPaymentBalance;
    private boolean didPaymentSucceed;

    CardPayment(BigDecimal cardPaymentBalance) {
        this.cardPaymentBalance = cardPaymentBalance;
        didPaymentSucceed = false;
    }

    @Override
    public PaymentResult pay(BigDecimal amountOwed) {
        if (amountOwed.doubleValue() > cardPaymentBalance.doubleValue()) {
            return new PaymentResult(false, "CP-Failed", "Insufficient funds");
        } else {
            cardPaymentBalance = cardPaymentBalance.subtract(amountOwed);
            didPaymentSucceed = true;
            return new PaymentResult(true, "CP-Success", "Your card payment succeeded");
        }
    }

    @Override
    public String getDisplayName() {
        return didPaymentSucceed ? "\nPayment Type: Voucher | Reference: VCH-Success" : "\nPayment Type: Voucher | Reference: VCH-Failed";
    }
}
