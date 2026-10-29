package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("YTU-1001", "Thabo", new BigDecimal(249.99), DeliveryMethod.EXPRESS_DELIVERY);
        order.confirmOrder();
        order.setPaymentStatus(PaymentStatus.FAILED);
        order.Summary();
        order.confirmOrder();
        order.Summary();
        order.nextStatus();
        order.Summary();
        order.nextStatus();
        order.Summary();
        order.nextStatus();
        order.Summary();
        order.nextStatus();
        order.Summary();

        Order order1 = new Order("YTU-1002", "Karabo", new BigDecimal(450.99), DeliveryMethod.EXPRESS_DELIVERY);
     order1.setPaymentStatus(PaymentStatus.PAID);
        order1.confirmOrder();
        order1.nextStatus();
        order1.nextStatus();
        order1.nextStatus();
        order1.nextStatus();
        order1.Summary();

        Order order2 = new Order("YTU-1003", "Palesa", new BigDecimal(180.99), DeliveryMethod.STANDARD_DELIVERY);
        order2.setPaymentStatus(PaymentStatus.PAID);
        order2.confirmOrder();

        order2.nextStatus();
        order2.cancelOrder();

        order2.Summary();

        PaymentMethod cardPayment = new CardPayment(new BigDecimal(300));
        PaymentMethod EFTPayment = new InstantEFTPayment(new BigDecimal(200.00));
        PaymentMethod voucherPayment = new VoucherPayment(new BigDecimal(100.0));

        CheckoutService service = new CheckoutService(cardPayment);
        service.checkout(new BigDecimal(150.00));
        System.out.println(cardPayment.getDisplayName());;

        CheckoutService service1 = new CheckoutService(EFTPayment);
        service1.checkout(new BigDecimal(199.00));
        System.out.println(EFTPayment.getDisplayName());

        CheckoutService service2 = new CheckoutService(voucherPayment);
        service2.checkout(new BigDecimal(90.00));
        System.out.println(voucherPayment.getDisplayName());
    }
}
