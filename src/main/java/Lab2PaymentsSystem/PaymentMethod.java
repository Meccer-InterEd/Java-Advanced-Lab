package Lab2PaymentsSystem;
import java.math.BigDecimal;

public interface PaymentMethod {
    PaymentResult pay(BigDecimal amount);
    String getDisplayName();


}
