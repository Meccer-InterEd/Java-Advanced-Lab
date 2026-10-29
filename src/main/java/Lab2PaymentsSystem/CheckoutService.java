package Lab2PaymentsSystem;
import java.math.BigDecimal;

public class CheckoutService {
    public PaymentResult checkout(PaymentMethod paymentMethod, BigDecimal amount) {
        PaymentResult result;

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            result = PaymentResult.failure("Amount must be greater than zero.");
        } else {
            result = paymentMethod.pay(amount);
        }

        System.out.println("Payment method: " + paymentMethod.getDisplayName());
        System.out.println("Amount: R" + amount);
        System.out.println("Result: " + (result.successful() ? "SUCCESS" : "FAILED")
                + " - " + result.message());
        System.out.println("Reference: " + result.reference());
        System.out.println();

        return result;
    }
}
