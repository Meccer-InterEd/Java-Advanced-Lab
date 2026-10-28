package org.example.Lab2InterfacePaymentSystem;

import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod {
    private BigDecimal eftBalance;
    PaymentResult pr = new PaymentResult(false, "moe", "Failed");


    public InstantEftPayment(BigDecimal EftBalance) {
        this.eftBalance = eftBalance;

    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (eftBalance.compareTo(amount) >= 0) {
            this.eftBalance = this.eftBalance.subtract(amount);
            pr = new PaymentResult(true, "EFTPayment", "EFT Payment Successful");
            return pr;
        }
        pr = new PaymentResult(false, "Failed EFT-P", "Failed EFT Payment");
        return pr;
    }

    @Override
    public String getDisplayName() {
        return "Instant EFT Payment";
    }

    @Override
    public String summary() {
        return "Payment Successful? " + pr.successful() + "\nReference - " + pr.reference() + "\nOutput - " + pr.message() ;
    }
}
