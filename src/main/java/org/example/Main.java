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
        order.Payment(new BigDecimal("290.99"));

        Order order2 = new Order(
                "  SFG-1006",
                "Karabo",
                new BigDecimal("100.00"),
                DeliveryMethod.COLLECTION
        );
        order2.Payment(new BigDecimal("100.00"));

        Order order3 = new Order(
                "  FTG-1009",
                "Thabo",
                new BigDecimal("1000.99"),
                DeliveryMethod.EXPRESS_DELIVERY
        );
        order3.Payment(new BigDecimal("1000.00"));
    }

}
