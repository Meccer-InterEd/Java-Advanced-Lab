package Lab2PaymentsSystem;
import java.math.BigDecimal;
import java.util.List;

public class PSMain {
    public static void main(String[] args){
        PaymentResult payRes = new PaymentResult(false,"Ditebogo Shoes","Unsuccesful");
        CheckoutService checkout = new CheckoutService();


        PaymentMethod card = new CardPayment();
        PaymentMethod eft = new InstantEFT("GO TYMEBANK");
        PaymentMethod voucher = new VoucherPayment("DIDI100", new BigDecimal("100.00"));

        System.out.println("Normal payments");
        checkout.checkout(card, new BigDecimal("250.50"));
        checkout.checkout(eft, new BigDecimal("899.99"));
        checkout.checkout(voucher, new BigDecimal("60.00"));

        System.out.println("Rule failures");
        checkout.checkout(card, new BigDecimal("15000.00"));    // over card limit
        checkout.checkout(eft, new BigDecimal("7500.00"));      // over EFT limit
        checkout.checkout(voucher, new BigDecimal("60.00"));    // only R40 left

        System.out.println("Invalid amounts");
        checkout.checkout(card, BigDecimal.ZERO);
        checkout.checkout(eft, new BigDecimal("-10.00"));

        System.out.println("PaymentMethod in a loop");
        List<PaymentMethod> methods = List.of(card, eft, voucher);
        for (PaymentMethod method : methods) {
            checkout.checkout(method, new BigDecimal("10.00"));
        }
    }
}
