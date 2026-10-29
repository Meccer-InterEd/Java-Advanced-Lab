package Lab_2;

import java.math.BigDecimal;

public class EFTpayment implements PaymentMethod {
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(
                true,
                "EFT123",
                "EFT payment successful"
        );
    }
    public String getDisplayName() {
        return "EFT_Payment";
    }
}

