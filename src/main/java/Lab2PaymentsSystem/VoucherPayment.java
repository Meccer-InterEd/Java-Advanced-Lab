package Lab2PaymentsSystem;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{

    private final String voucherCode;
    private BigDecimal balance;

    public VoucherPayment(String voucherCode, BigDecimal balance) {
        this.voucherCode = voucherCode;
        this.balance = balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (amount.compareTo(balance) > 0){
            return PaymentResult.failure("Voucher balance R" + balance +" is not enough for R" + amount);
        }
        balance = balance.subtract(amount);
        return PaymentResult.success("Voucher: " + voucherCode, "Voucher accepted. Remaining balance: R" + balance);
    }

    @Override
    public String getDisplayName() {
        return "Voucher " + voucherCode;
    }
}
