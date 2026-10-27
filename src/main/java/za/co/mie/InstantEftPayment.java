package za.co.mie;

import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod {
    @Override
    public PaymentResult pay(BigDecimal amount) {
        return amount.compareTo(new BigDecimal("50000")) <= 0 ? PaymentResult.approved() : PaymentResult.declined("Bank limit exceeded");
    }

    @Override
    public String get_display_name() {
        return "Instant EFT";
    }
}
