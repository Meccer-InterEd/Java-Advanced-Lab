package lab2;

import lab2.classes.CardPayment;
import lab2.classes.VoucherPayment;
import lab2.interfaces.PaymentMethod;

public class main
{

    public static void main(String[] args) {

        CheckoutService cs = new CheckoutService();
        PaymentMethod pr = new VoucherPayment(500);
        cs.checkout(pr,500);
        PaymentMethod pr2 = new CardPayment("40585885858585");
        cs.checkout(pr2,500);


    }

}
