package za.co.mie;

import java.math.BigDecimal;

public class CheckoutService {
    public PaymentResult checkout(PaymentMethod payment_method, BigDecimal amount) {
        if (payment_method == null) throw new IllegalArgumentException("Payment method is required");
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be greater than zero");
        return payment_method.pay(amount);
    }

    public void display_checkout(PaymentMethod payment_method, BigDecimal amount) {
        PaymentResult result = checkout(payment_method, amount);
        System.out.println(payment_method.get_display_name() + " R" + amount + " -> " + (result.successful() ? "SUCCESS" : "FAILED") + " | " + result.message() + " | ref " + result.reference());
    }
}
