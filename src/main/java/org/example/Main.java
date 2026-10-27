package org.example;




import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("ORD-1001", "Lerato", "249.99",OrderStatus.PLACED, PaymentStatus.PENDING, DeliveryMethod.STANDARD_DELIVERY);
        order.displayStatus();




    }


}

