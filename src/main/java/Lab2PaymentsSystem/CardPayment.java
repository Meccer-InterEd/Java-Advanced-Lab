package Lab2PaymentsSystem;
import java.math.BigDecimal;


public class CardPayment implements PaymentMethod {

    private static final BigDecimal cardLimit = new BigDecimal("10000.00");
    private static final BigDecimal balance = new BigDecimal("55000.00");

    @Override
    public PaymentResult pay(BigDecimal amount) {

        String reference = "";

        if (amount.compareTo(cardLimit) > 0 ) {
            return PaymentResult.failure("Card declined due to exceeded limit");
        }
        else if (amount.compareTo(balance) > 0){
            return PaymentResult.failure("Card declined due to insufficient funds");
        }
        else{
            return PaymentResult.success(reference,"Card payment approved");
        }
    }


    @Override
    public String getDisplayName() {
        return "";
    }
}
