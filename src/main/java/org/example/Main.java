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
    }
}
