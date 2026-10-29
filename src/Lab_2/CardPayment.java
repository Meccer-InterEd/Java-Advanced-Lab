package Lab_2;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{

  public PaymentResult pay(BigDecimal amount) {
     return new PaymentResult (
             true,
             "FNB32",
             "Card payment"

);

  }
public String getDisplayName() {
      return "Card_Payment";
}

}

