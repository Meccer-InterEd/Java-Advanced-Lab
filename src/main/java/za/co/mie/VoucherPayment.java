package za.co.mie;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod {
    private BigDecimal balance;

    public VoucherPayment(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (amount.compareTo(balance) > 0) return PaymentResult.declined("Amount is more than voucher balance of R" + balance);
        balance = balance.subtract(amount);
        return PaymentResult.approved();
    }

    @Override
    public String get_display_name() {
        return "Voucher";
    }
}
