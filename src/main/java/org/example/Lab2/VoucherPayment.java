package org.example.Lab2;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod{

    private BigDecimal balance;
    private static int counter = 1;

    public VoucherPayment(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {

        // Check whether the voucher has enough money.
        if (amount.compareTo(balance) > 0) {

            return new PaymentResult(
                    false,
                    "null",
                    "Not enough money on voucher."
            );
        }

        // Subtract the payment from the balance.
        balance = balance.subtract(amount);

        counter++;

        return new PaymentResult(
                true,
                "VOUCHER-" + counter,
                "Voucher payment successful. Balance : R" + balance
        );
    }

    @Override
    public String getDisplayName() {
        return "Voucher";
    }
}
