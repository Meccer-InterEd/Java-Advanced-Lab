package org.example;

import java.math.BigDecimal;

public class InstantEFTPayment implements PaymentMethod{
    private  BigDecimal eftPaymentBalance;
    private  boolean didPaymentSucceed;

    InstantEFTPayment(BigDecimal eftPayment) {
        this.eftPaymentBalance = eftPayment;
        didPaymentSucceed = false;
    }

    @Override
    public PaymentResult pay(BigDecimal amountOwed) {
            if (amountOwed.doubleValue() > eftPaymentBalance.doubleValue()){
                return new PaymentResult(false,"EFT -Failed", "Insufficient funds") ;
            }
            else {
                eftPaymentBalance = eftPaymentBalance.subtract(amountOwed);
                didPaymentSucceed = true;
                return  new PaymentResult(true,"EFT-Success","Your EFT payment succeeded");
            }
    }

    @Override
    public String getDisplayName() {
        return didPaymentSucceed ? "\nPayment Type: EFT Payment | Reference: EFT-Success" : "\nPayment Type: EFT Payment | Reference: EFT-Failed";
    }
}
