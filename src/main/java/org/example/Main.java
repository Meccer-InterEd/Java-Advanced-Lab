package org.example;




import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(
                "ORD-1001",
                "Lerato",
                new BigDecimal("249.99"),

                DeliveryMethod.STANDARD_DELIVERY
        );
        Order order1= new Order("ORD-1002",
                "Lethabo",
                new BigDecimal("190.00"),DeliveryMethod.EXPRESS_DELIVERY);
        Order order2 = new Order("ORD-1003",
                "Lebogang",
                new BigDecimal("400.00"),DeliveryMethod.EXPRESS_DELIVERY);
        order2.confirmingOrder();
        order2.setPaymentStatus(PaymentStatus.PAID);
        order2.displayOrderSummary();
    }
}
