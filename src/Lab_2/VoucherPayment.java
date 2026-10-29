package Lab_2;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(
                true,
                "567890123",
                "Voucher payment was successful"
        );
    }
    public String getDisplayName() {
        return "Voucher_Payment";
    }

}
