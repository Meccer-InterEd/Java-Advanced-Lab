package org.example;
import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod {

    @Override
    public PaymentResult pay(BigDecimal amount) {

        return new PaymentResult(
                true,
                "EFT-1001",
                "Instant EFT payment successful"
        );
    }

    @Override
    public String getDisplayName() {
        return "Instant EFT Payment";
    }
}