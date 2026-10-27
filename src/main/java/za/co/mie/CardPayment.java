package za.co.mie;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
    private final BigDecimal limit;

    public CardPayment(BigDecimal limit) {
        this.limit = limit;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        return amount.compareTo(limit) <= 0 ? PaymentResult.approved() : PaymentResult.declined("Card limit exceeded");
    }

    @Override
    public String get_display_name() {
        return "Card";
    }
}
