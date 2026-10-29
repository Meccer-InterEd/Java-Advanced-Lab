package Lab2PaymentsSystem;

import java.math.BigDecimal;
import java.util.UUID;

public class InstantEFT implements PaymentMethod{

    private static final BigDecimal eft = new BigDecimal("10000.00");
    private final String bankName;

    public InstantEFT(String bankName)
    {
        this.bankName = bankName;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        if (amount.compareTo(eft) > 0)
        {
            return PaymentResult.failure("Instant eft failed: " + bankName + "limit is R" + eft);

        }
        //This code creates a reference from a Universal Unique identifier by randomizing it and transfering it to a string then taking the first 8 digits and taking it to UpperCase
        String reference = "EFT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return PaymentResult.success(reference, "Instant EFT confirmed by " + bankName + ".");
    }

    @Override
    public String getDisplayName() {
        return "Instant EFT (\" + bankName + \")";
    }
}
