package za.co.mie;

import java.util.UUID;

public record PaymentResult(boolean successful, String reference, String message) {
    public static PaymentResult approved() {
        return new PaymentResult(true, UUID.randomUUID().toString().substring(0, 8), "Payment approved");
    }

    public static PaymentResult declined(String message) {
        return new PaymentResult(false, "none", message);
    }
}
